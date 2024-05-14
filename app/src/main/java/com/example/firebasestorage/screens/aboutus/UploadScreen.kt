package com.example.firebasestorage.screens.aboutus

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.firebasestorage.navigation.ADD_TEACHERS_URL
import com.example.firebasestorage.ui.theme.blue

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Aboutus()

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Aboutus(){
    val mContext = LocalContext.current

    Column(modifier = Modifier.fillMaxSize()) {

        androidx.compose.material3.TopAppBar(title = {
            androidx.compose.material3.Text(
                text = "DOMESTIC MANAGERS",
                color = Color.White
            )
        },
            colors = TopAppBarDefaults.mediumTopAppBarColors(blue),
            navigationIcon = {
                androidx.compose.material3.IconButton(onClick = { /*TODO*/ }) {
                    androidx.compose.material3.Icon(
                        imageVector = Icons.Default.Menu,
                        contentDescription = "",
                        tint = Color.White
                    )

                }


            },


        )
        Text(text = "Domestic chores simplified",
            modifier = Modifier
                .fillMaxWidth(),
                color = Color.Blue,
                fontSize = 25.sp,

            )
        Spacer(modifier = Modifier.height(10.dp))

        Text(text = "\uD83C\uDF1F Welcome to DOMESTIC MANAGERS APP!\n" +
                "\n" +
                "Hello there! I'm Gichiri Kinuthia, the Founder and the CEO of Domestic Managers Kenya. I'm thrilled to have you here and share a bit about our story.\n" +
                "\n" +
                "At D.M, we believe in making your day to day house chores as simple as possible. Our journey began way back when one of our female  employees never showed to work , and upon reaching out to her we realised its because ; her househelp decided to quit that morning as she was just about to leave for work, and since then, we've been on a mission to make sure that doesn't affect anyone in any near future. Every project, every product, and every interaction is guided by our passion for [your main focus or purpose].\n" +
                "\n" +

                "Thank you for being a part of the Domestic Managers community. Feel free to reach out if you have any questions or just want to say hello!\n" +
                "\n" +
                "Cheers,\n" +
                "[Gichiri Kinuthia")







    }


}
@Preview(showBackground = true)
@Composable
fun AboutusPreview(){
    Aboutus()
}