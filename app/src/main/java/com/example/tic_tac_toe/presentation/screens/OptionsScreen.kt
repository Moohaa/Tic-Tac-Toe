package com.example.tic_tac_toe.presentation.screens

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.tic_tac_toe.presentation.Components.OptionCard
import com.example.tic_tac_toe.presentation.Screen
import org.intellij.lang.annotations.JdkConstants

@Composable
fun OptionsScreen(
    navController: NavController
){

    Box(modifier = Modifier.fillMaxSize()){
        Column(
            modifier= Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            OptionCard("Play Online", navigate = {
                navController.navigate(Screen.LoginScreen.route)
            })
            OptionCard("Play offline",
                navigate = {
                    navController.navigate(Screen.LoginScreen.route)
                })
        }
    }
}
