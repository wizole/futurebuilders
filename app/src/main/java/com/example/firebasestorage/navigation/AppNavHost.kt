package com.example.firebasestorage.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.firebasestorage.screens.clean.homecleaning
import com.example.firebasestorage.screens.innoviate.housekeeping
import com.example.firebasestorage.screens.about.teacherservices
import com.example.firebasestorage.screens.contact.ContactScreen
import com.example.firebasestorage.screens.home.MyHomeScreen
import com.example.firebasestorage.screens.login.LoginScreen
import com.example.firebasestorage.screens.teachers.ViewTeachersScreen
import com.example.firebasestorage.screens.signup.SignupScreen
import com.example.firebasestorage.screens.aboutus.Aboutus
import com.example.firebasestorage.screens.home.HomeScreen
import com.example.firebasestorage.screens.teachers.AddTeachersScreen


@Composable
fun AppNavHost(modifier: Modifier = Modifier,
               navController:NavHostController = rememberNavController(),
               startDestination:String = ROUT_LOGIN) {
    NavHost(navController = navController, modifier=modifier,
        startDestination = startDestination){
        composable(ROUT_HOME){
            HomeScreen(navController= navController)
        }

        composable(MYHOMESCREEN){
            MyHomeScreen(navController= navController)
        }

        composable(ROUT_LOGIN){

             LoginScreen(navController)
        }

        composable(ROUT_SIGNUP){
            SignupScreen(navController)
        }

        composable(ROUT_CONTACT){
            ContactScreen(navController)
        }

        composable(ROUT_UPLOAD){
           Aboutus()
        }
        composable(ADD_TEACHERS_URL){
            AddTeachersScreen(navController = navController)
        }
        composable(VIEW_TEACHERS_URL){
            ViewTeachersScreen(navController = navController)
        }
        composable(CLEANING_URL){
            homecleaning(navController = navController)
        }
        composable(KEEPING_URL){
            housekeeping(navController = navController)
        }
        composable(MAID_URL){
            teacherservices(navController = navController)
        }





    }
}