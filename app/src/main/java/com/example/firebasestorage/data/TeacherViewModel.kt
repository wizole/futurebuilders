package com.example.firebasestorage.data

import android.app.ProgressDialog
import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation.NavHostController
import com.example.firebasestorage.models.Teacher
import com.example.firebasestorage.navigation.ROUT_LOGIN
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.storage.FirebaseStorage

class   TeacherViewModel(var navController:NavHostController, var context: Context) {
    var authViewModel:AuthViewModel
    var progress:ProgressDialog
    init {
        authViewModel = AuthViewModel(navController, context)
        if (!authViewModel.isLoggedIn()){
            navController.navigate(ROUT_LOGIN)
        }
        progress = ProgressDialog(context)
        progress.setTitle("Loading")
        progress.setMessage("Please wait...")
    }

    fun uploadTeacher(name:String, phone: String, email: String, profession: String, filePath:Uri){
        val teacherId = System.currentTimeMillis().toString()
        val storageRef = FirebaseStorage.getInstance().getReference()
            .child("Teachers/$teacherId")
        progress.show()
        storageRef.putFile(filePath).addOnCompleteListener{
            progress.dismiss()
            if (it.isSuccessful){
                // Save data to db
                storageRef.downloadUrl.addOnSuccessListener {
                    var imageUrl = it.toString()
                    var teacher = com.example.firebasestorage.models.Teacher(name,phone,email,profession,imageUrl,teacherId)
                    var databaseRef = FirebaseDatabase.getInstance().getReference()
                        .child("Teachers/$teacherId")
                    databaseRef.setValue(teacher).addOnCompleteListener {
                        if (it.isSuccessful){
                            Toast.makeText(this.context, "Success", Toast.LENGTH_SHORT).show()
                        }else{
                            Toast.makeText(this.context, "Error", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }else{
                Toast.makeText(this.context, "Upload error", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun allTeachers(
        teacher:MutableState<Teacher>,
        teachers:SnapshotStateList<Teacher>):SnapshotStateList<Teacher>{
        progress.show()
        var ref = FirebaseDatabase.getInstance().getReference()
            .child("Teachers")
        ref.addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                teachers.clear()
                for (snap in snapshot.children){
                    var retrievedTeacher = snap.getValue(  Teacher::class.java)
                    teacher.value = retrievedTeacher!!
                    teachers.add(retrievedTeacher)
                }
                progress.dismiss()
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, "DB locked", Toast.LENGTH_SHORT).show()
            }
        })
        return teachers
    }

    fun deleteTeacher(teacherId:String){
        var ref = FirebaseDatabase.getInstance().getReference().child("Teachers/$teacherId")
        ref.removeValue()
        Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
    }
}