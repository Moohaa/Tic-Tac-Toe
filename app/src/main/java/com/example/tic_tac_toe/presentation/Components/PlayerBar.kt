package com.example.tic_tac_toe.presentation.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.tic_tac_toe.R
import com.example.tic_tac_toe.logic.OfflineGame

@Composable
fun PlayerBar(
    userName:String,
    game: OfflineGame
){
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ){
        Icon(
            tint =if(game.isMyTurn) Color.Green else Color.Red,
            modifier = Modifier
                .padding(15.dp, 5.dp, 5.dp, 10.dp)
                .size(45.dp)
                .clip(RoundedCornerShape(50))
                ,
            painter = painterResource(id= R.drawable.ic_baseline_account_circle_24), contentDescription = "notification button"
        )
        Column(){
            Text(text = userName,
            )
            // Todo : counter down
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
            ) {
                Text(
                    modifier = Modifier.padding(2.dp),
                    text = " 1:00 ",
                    color = Color.Red,
                )
            }
        }
    }
}