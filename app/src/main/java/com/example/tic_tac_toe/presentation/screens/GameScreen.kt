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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tic_tac_toe.R
import com.example.tic_tac_toe.logic.OfflineGame
import com.example.tic_tac_toe.presentation.Components.Cell
import com.example.tic_tac_toe.presentation.Components.OpponentBar
import com.example.tic_tac_toe.presentation.Components.PlayerBar
import com.example.tic_tac_toe.presentation.Components.ScoreBoard
import com.example.tic_tac_toe.presentation.ViewModels.GameViewModel

@Composable
fun GameScreen(
    viewModel: GameViewModel = hiltViewModel()
){
    var game =viewModel.game
    Column(
        modifier = Modifier.fillMaxSize(),
    ){
        Row(
            modifier =Modifier.fillMaxWidth(),

            horizontalArrangement = Arrangement.SpaceBetween
        ){
                PlayerBar(userName = "Player 1",game)
                ScoreBoard(player1Score = 0, player2Score = 0)
                OpponentBar(userName = "Player 2",game)
        }
        Divider()

        var p by remember {
            mutableStateOf(game.isMyTurn)
        }
        var i by remember {
            mutableStateOf(-1)
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.5f)
                .padding(20.dp, 40.dp, 20.dp, 40.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxHeight(0.3f)
                    .fillMaxWidth(),
            ) {
                Cell(0.3f,0,game) {index: Int ->
                    ChooseCell(index,game)
                    p=!p
                }
                Cell(0.5f,1,game) {index: Int ->
                    ChooseCell(index,game)
                    p=!p
                }
                Cell(1f,2,game) {index: Int ->
                    ChooseCell(index,game)
                    p=!p
                }

            }
            Row(
                modifier = Modifier
                    .fillMaxHeight(0.5f)
                    .fillMaxWidth(),
            ) {
                Cell(0.3f,3,game) {index: Int ->
                    ChooseCell(index,game)
                    p=!p
                }
                Cell(0.5f,4,game) {index: Int ->
                    ChooseCell(index,game)
                    p=!p
                }
                Cell(1f,5,game) {index: Int ->
                    ChooseCell(index,game)
                    p=!p
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(),
            ) {
                Cell(0.3f,6,game){index: Int ->
                    ChooseCell(index,game)
                    p=!p
                }
                Cell(0.5f,7,game) {index: Int ->
                    ChooseCell(index,game)
                    p=!p
                }
                Cell(1f,8,game){index: Int ->
                    ChooseCell(index,game)
                    p=!p
                }
            }
        }
        Divider()

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if(!p){
                if(!game.isMyTurn){
                    game.chooseCell()
                    game.isMyTurn=true
                }
                p=!p
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .padding(20.dp, 5.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(MaterialTheme.colors.primary)
                    .clickable {
                        viewModel.restart()
                        p=!p
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

fun ChooseCell(index: Int,game:OfflineGame){
    if (game.isMyTurn && game.grid[index].chooseBy==-1){
        Log.d("ee",index.toString())
        game.makeMove(index)
        game.isMyTurn=false
    }

}