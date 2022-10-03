package com.example.tic_tac_toe.presentation.screens

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.tic_tac_toe.presentation.Components.OptionCard
import com.example.tic_tac_toe.presentation.Screen
import com.example.tic_tac_toe.R



@Composable
fun OptionsScreen(
    navController: NavController
){
    Box(modifier = Modifier.fillMaxSize()){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 0.dp),
            horizontalArrangement = Arrangement.End
        ) {
            IconButton(onClick = {
            }){
                Icon(
                    modifier = Modifier.padding(20.dp,15.dp),
                    painter = painterResource(id= R.drawable.ic_baseline_notifications_none_24 ), contentDescription = "notification button")
            }
        }
        Column(
            modifier= Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Row {
                Icon(
                    modifier = Modifier.padding(40.dp,70.dp),
                    tint = MaterialTheme.colors.primary,
                    painter = painterResource(id= R.drawable.ic_tic_tac_toe), contentDescription = "notification button"
                )
            }
            OptionCard("Play Online", navigate = {
                navController.navigate(Screen.GetUserName.route)
            })
            OptionCard("Play offline",
                navigate = {
                    navController.navigate(Screen.GameScreen.route)
                })
        }
    }
}
