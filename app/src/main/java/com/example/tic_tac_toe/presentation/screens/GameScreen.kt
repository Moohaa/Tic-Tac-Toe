package com.example.tic_tac_toe.presentation.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.tic_tac_toe.R
import com.example.tic_tac_toe.presentation.Components.Cell
import com.example.tic_tac_toe.presentation.Components.OpponentBar
import com.example.tic_tac_toe.presentation.Components.PlayerBar
import com.example.tic_tac_toe.presentation.Components.ScoreBoard

@Composable
fun GameScreen(){
    Column(
        modifier = Modifier.fillMaxSize(),
    ){
        Row(
            modifier =Modifier.fillMaxWidth(),

            horizontalArrangement = Arrangement.SpaceBetween
        ){
                PlayerBar(userName = "Player 1")
                ScoreBoard(player1Score = 15, player2Score = 60)
                OpponentBar(userName = "Player 2")
        }
        Divider()

        var blocked by remember {
            mutableStateOf(false)
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.5f)
                .padding(20.dp, 40.dp,20.dp,40.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxHeight(0.3f)
                    .fillMaxWidth(),
            ) {
                Cell(0.3f,false,blocked)
                Cell(0.5f,false,blocked)
                Cell(1f,false,blocked)
            }
            Row(
                modifier = Modifier
                    .fillMaxHeight(0.5f)
                    .fillMaxWidth(),
            ) {
                Cell(0.3f,false,blocked)
                Cell(0.5f,false,blocked)
                Cell(1f,false,blocked)
            }
            Row(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(),
            ) {
                Cell(0.3f,false,blocked)
                Cell(0.5f,false,blocked)
                Cell(1f,false,blocked)
            }
        }
        Divider()

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Player 1 won !!",
            modifier = Modifier.padding(10.dp,20.dp)
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .padding(20.dp, 5.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(MaterialTheme.colors.primary)
                    .clickable {
                        blocked=true

                    },
                Alignment.Center,
            ){
                Text(
                    text = "Play again",
                    modifier = Modifier.padding(20.dp),
                    textAlign = TextAlign.Center,
                    color = Color.White
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .padding(20.dp, 5.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(MaterialTheme.colors.primary)
                    .clickable {
                    },
                Alignment.Center,
            ){
                Text(
                    text = "Finish",
                    modifier = Modifier.padding(20.dp),
                    textAlign = TextAlign.Center,
                    color = Color.White
                )
            }
        }
    }
}