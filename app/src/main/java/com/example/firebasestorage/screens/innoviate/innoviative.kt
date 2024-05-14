package com.example.firebasestorage.screens.innoviate

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition

import com.example.firebasestorage.R
import com.example.firebasestorage.navigation.MAID_URL
import com.example.firebasestorage.ui.theme.blue
import com.example.firebasestorage.ui.theme.orange

@Composable
fun housekeeping(navController: NavHostController) {

    val mContext= LocalContext.current
    Column(modifier= Modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.height(30.dp))

        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
            //Lottie Animation
            val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.innovate))
            val progress by animateLottieCompositionAsState(composition)
            LottieAnimation(composition, progress,
                modifier = Modifier.size(450.dp)
            )

        }

        Spacer(modifier = Modifier.height(10.dp))


        Text(text = "Innovative Curriculum",
            color = orange,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontSize = 30.sp,
            fontWeight = FontWeight.ExtraBold)

        Spacer(modifier = Modifier.height(15.dp))


        Text(text = "The academy offers a dynamic curriculum that blends traditional subjects with cutting-edge topics such as technology, sustainability, and entrepreneurship. Through hands-on projects, experiential learning opportunities, and interdisciplinary studies, students are encouraged to explore their passions and cultivate a deep understanding of the world around them.",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontSize = 15.sp)

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            navController.navigate(MAID_URL)
            Toast.makeText(mContext, "Maid Services", Toast.LENGTH_LONG)
                .show()
        },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp),
            colors = ButtonDefaults.buttonColors(blue),
            shape = RoundedCornerShape(5.dp)
        ) {
            Text(text = "Next")

        }


    }




}


