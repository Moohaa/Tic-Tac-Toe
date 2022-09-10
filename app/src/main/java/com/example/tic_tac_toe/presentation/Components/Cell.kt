package com.example.tic_tac_toe.presentation.Components

import android.text.BoringLayout
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.runtime.R
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun Cell(
    fraction : Float,
    clicked : Boolean,
    blocked:Boolean
){
    var t by remember {
        mutableStateOf(clicked)
    }
    Box(
        modifier = Modifier
        .fillMaxWidth(fraction)
        .fillMaxHeight()
        .border(2.dp, MaterialTheme.colors.primary)
        .clickable {
            if(!blocked) t = true

        },
    ){
        if(t){
            Icon(
                modifier = Modifier
                    .padding(5.dp, 5.dp, 15.dp, 10.dp)
                    .align(Alignment.Center)
                    .size(45.dp),
                painter = painterResource(id= com.example.tic_tac_toe.R.drawable.ic_baseline_account_circle_24), contentDescription = "notification button",
            )
        }
    }
}