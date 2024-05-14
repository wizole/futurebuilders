package com.example.firebasestorage.screens.home



import android.content.Intent
import android.provider.Settings
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.firebasestorage.navigation.ADD_TEACHERS_URL
import com.example.firebasestorage.navigation.ROUT_LOGIN
import com.example.firebasestorage.navigation.VIEW_TEACHERS_URL

import com.example.firebasestorage.ui.theme.FirebasestorageTheme
import com.example.firebasestorage.ui.theme.LightBlue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyHomeScreen(navController:NavHostController){

    val mContext= LocalContext.current

    Column (modifier = Modifier.fillMaxSize()){
        //TopAppBar
        TopAppBar(title = { Text(text = "Products") },
            navigationIcon = {
                IconButton(onClick = {
                    mContext.startActivity(Intent(mContext, ROUT_LOGIN::class.java))
                }) {
                    Icon(imageVector = Icons.Filled.ArrowBack , contentDescription = "arrowback")
                }
            },
            colors = TopAppBarDefaults.mediumTopAppBarColors(LightBlue))



        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Spacer(modifier = Modifier.height(30.dp))


            Box (modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center){
                Button(onClick = {
                },
                    shape = CutCornerShape(5.dp)) {
                    Icon(imageVector = Icons.Filled.Info, contentDescription ="", tint = Color.White )
                    Text(text = "List of teachers details")
                }
            }




        }
    }
}

@Composable
@Preview(showBackground = true)
fun MyHomeScreenPreview(){
    MyHomeScreen(navController = rememberNavController())

}