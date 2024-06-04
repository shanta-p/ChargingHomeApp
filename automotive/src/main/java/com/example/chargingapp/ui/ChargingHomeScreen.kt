package com.example.chargingapp.ui

import android.widget.ImageButton
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.chargingapp.R

/**
 * Created by shanta on 1/5/24
 */

@Composable
fun ChargingHomeScreen(){
    Scaffold { padding ->

        Row(modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(padding),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {

            Column(modifier = Modifier
                .fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceEvenly
                ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        modifier = Modifier
                            .padding(end = 12.dp),
                        painter = painterResource(id = R.drawable.ic_charging_status),
                        contentDescription = "")

                    Text(text = "Charging")

                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        modifier = Modifier
                            .padding(end = 12.dp),
                        painter = painterResource(id = R.drawable.ic_cable_status),
                        contentDescription = "")

                    Text(text = "Cable Connected")

                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        modifier = Modifier
                            .padding(end = 12.dp),
                        painter = painterResource(id = R.drawable.ic_hatch_status),
                        contentDescription = "",)

                    Text(text = "Hatch Open")

                }
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .size(300.dp)
                        .padding(4.dp),
                    progress = { 0.4f },
                    trackColor = MaterialTheme.colorScheme.scrim,
                    color = Color.Green,
                    strokeWidth = 20.dp,
                    strokeCap = StrokeCap.Round,
                )
                Spacer(modifier = Modifier.height(24.dp))
                OutlinedButton(
                    modifier = Modifier
                        .width(400.dp),
                    shape = RoundedCornerShape(10.dp),
                    border = BorderStroke(2.dp, MaterialTheme.colorScheme.primary),
                    onClick = {}
                ){
                    Icon(
                        painter = painterResource(id = R.drawable.ic_start_charging_foreground),
                        contentDescription = "")
                    Text(text = "Start Charging")
                }
            }
        }
    }
}