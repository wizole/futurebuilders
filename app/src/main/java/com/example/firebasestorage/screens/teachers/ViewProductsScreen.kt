package com.example.firebasestorage.screens.teachers


import android.net.Uri
import android.provider.ContactsContract.CommonDataKinds.Phone
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.example.firebasestorage.data.TeacherViewModel
import com.example.firebasestorage.models.Teacher

import com.example.firebasestorage.ui.theme.blue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ViewTeachersScreen(navController:NavHostController) {
    var mContext = LocalContext.current
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {


        var teacherRepository = TeacherViewModel(navController, mContext)


        val emptyTeacherState = remember { mutableStateOf(Teacher("","","","","","")) }
        var emptyTeachersListState = remember { mutableStateListOf<Teacher>() }

        var teachers = teacherRepository.allTeachers(emptyTeacherState, emptyTeachersListState)


        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            TopAppBar(
                title = { Text("Teachers Information") },
                colors = TopAppBarDefaults.largeTopAppBarColors(blue),
                navigationIcon = {
                    IconButton(onClick = {/* Do Something*/ }) {
                        Icon(Icons.Filled.Menu, null)
                    }
                })


            Spacer(modifier = Modifier.height(20.dp))

            LazyColumn(){
                items(teachers){
                    TeacherItem(
                        name = it.name,
                        phone = it.phone,
                        email = it. email,
                        profession = it. profession,
                        id = it.id,
                        navController = navController,
                        teacherRepository = teacherRepository,
                        teacherImage = it.imageUrl
                    )
                }
            }
        }
    }
}


@Composable
fun TeacherItem(name:String, phone: String, email: String, profession: String,id:String,
                navController:NavHostController,
                teacherRepository:TeacherViewModel, teacherImage:String) {
    val mContext= LocalContext.current

    Column(modifier = Modifier
        .fillMaxWidth()
        .fillMaxSize()) {

        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
            Image(
                painter = rememberAsyncImagePainter(teacherImage),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.FillBounds
            )
        }

        Row(modifier = Modifier.padding(start = 60.dp)) {
            Text(text = "Teacher Full Name :", fontWeight = FontWeight.Bold, fontSize = 15.sp)
            Text(text = name)
        }

        Row(modifier = Modifier.padding(start = 60.dp)) {
            Text(text = "Phone Number :",
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp)
            Text(text = phone)
        }
        Row(modifier = Modifier.padding(start = 60.dp)) {
            Text(text = "Email Address :", fontWeight = FontWeight.Bold,fontSize = 15.sp)
            Text(text = email)
        }
        Row(modifier = Modifier.padding(start = 60.dp)) {
            Text(text = "Your Profession:", fontWeight = FontWeight.Bold, fontSize = 15.sp)
            Text(text = profession)
        }

        Box (modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center){
            Button(onClick = {
                teacherRepository.deleteTeacher(id)
            },shape = RoundedCornerShape(5.dp)  ,
                colors = ButtonDefaults.buttonColors(blue),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp)) {
                Text(text = "Delete")
                
                Spacer(modifier = Modifier.height(20.dp))
            }
        }





    }
}

@Composable
@Preview(showBackground = true)
fun ViewTeachersScreenPreview(){

    ViewTeachersScreen(navController = rememberNavController())

}