package com.example.firebasestorage.screens.clean

import android.annotation.SuppressLint
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.firebasestorage.R
import com.example.firebasestorage.navigation.KEEPING_URL
import com.example.firebasestorage.ui.theme.blue
import com.example.firebasestorage.ui.theme.orange

@SuppressLint("ComposableNaming")
@Composable
fun homecleaning(navController: NavHostController) {

    val mContext= LocalContext.current

    Column(modifier= Modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.height(30.dp))

        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
            //Lottie Animation
            val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.mission))
            val progress by animateLottieCompositionAsState(composition)
            LottieAnimation(composition, progress,
                modifier = Modifier.size(450.dp)
            )

        }

        Spacer(modifier = Modifier.height(10.dp))


        Text(text = "OUR MISSION",
            color = orange,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontSize = 30.sp,
            fontWeight = FontWeight.ExtraBold)

        Spacer(modifier = Modifier.height(15.dp))


        Text(text = "Future Builders Academy aims to provide a transformative educational experience that equips students with the knowledge, skills, and mindset needed to thrive in a rapidly evolving world",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontSize = 15.sp)

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            navController.navigate(KEEPING_URL)
            Toast.makeText(mContext, "Housekeeping", Toast.LENGTH_LONG)
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

@Preview(showBackground = true)
@Composable
fun homecleaningPreview() {
    homecleaning(rememberNavController())

}
