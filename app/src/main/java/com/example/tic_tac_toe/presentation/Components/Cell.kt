package com.example.tic_tac_toe.presentation.Components

import android.text.BoringLayout
import android.util.Log
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.R
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.tic_tac_toe.logic.OfflineGame

@Composable
fun Cell(
    fraction : Float,
    index:Int,
    game :OfflineGame,
    change:(index :Int)->Unit
){
    var t by remember {
        mutableStateOf(game.grid[index].chooseBy)
    }
    Box(
        modifier = Modifier
            .fillMaxWidth(fraction)
            .fillMaxHeight()
            .border(2.dp, MaterialTheme.colors.primary)
            .clickable {
                change(index)
                t=game.grid[index].chooseBy
            },
    ){
        t=game.grid[index].chooseBy
        if(t==1){
            Icon(
                tint = Color.Blue,
                modifier = Modifier
                    .padding(5.dp, 5.dp, 15.dp, 10.dp)
                    .align(Alignment.Center)
                    .size(45.dp),
                painter = painterResource(id= com.example.tic_tac_toe.R.drawable.ic_shape), contentDescription = "notification button",
            )
        }
        if(t==0){
            Icon(
                tint = Color.Black,
                modifier = Modifier
                    .padding(5.dp, 5.dp, 15.dp, 10.dp)
                    .align(Alignment.Center)
                    .size(45.dp),
                painter = painterResource(id= com.example.tic_tac_toe.R.drawable.ic_cross), contentDescription = "notification button",
            )
        }
        if(t==2){
            if(game.finished==1){
                Icon(
                    tint = Color.Magenta,
                    modifier = Modifier
                        .padding(5.dp, 5.dp, 15.dp, 10.dp)
                        .align(Alignment.Center)
                        .size(45.dp),
                    painter = painterResource(id=com.example.tic_tac_toe.R.drawable.ic_shape), contentDescription = "notification button",
                )

            }else{
                Icon(
                    tint = Color.Magenta,
                    modifier = Modifier
                        .padding(5.dp, 5.dp, 15.dp, 10.dp)
                        .align(Alignment.Center)
                        .size(45.dp),
                    painter = painterResource(id=com.example.tic_tac_toe.R.drawable.ic_cross), contentDescription = "notification button",
                )
            }

        }



    }
}