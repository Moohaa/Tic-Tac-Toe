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
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ){
                Icon(
                    tint =if(game.isMyTurn) Color.Green else Color.Red,
                    modifier = Modifier
                        .padding(15.dp, 5.dp, 5.dp, 10.dp)
                        .clip(RoundedCornerShape(50))
                        .size(45.dp)
                    ,
                    painter = painterResource(id= R.drawable.ic_baseline_account_circle_24), contentDescription = "notification button"
                )
                Column(){
                    Text(text = "Me      ")
                }
            }
            ScoreBoard(player1Score = game.myScore, player2Score = game.oppponentScore)
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(){
                    Text(
                        text = "Computer",
                    )
                }
                Icon(
                    tint=if(!game.isMyTurn) Color.Green else Color.Red,
                    modifier = Modifier
                        .padding(5.dp, 5.dp, 15.dp, 10.dp)
                        .clip(RoundedCornerShape(50))
                        .size(45.dp),
                    painter = painterResource(id= R.drawable.ic_baseline_account_circle_24), contentDescription = "notification button"
                )
            }
        }
        Divider()
        var p by remember {
            mutableStateOf(true)
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
                    viewModel.ChooseCell(index,{ p=false })
                }
                Cell(0.5f,1,game) {index: Int ->
                    viewModel.ChooseCell(index,{ p=false })
                }
                Cell(1f,2,game) {index: Int ->
                    viewModel.ChooseCell(index,{ p=false })
                }

            }
            Row(
                modifier = Modifier
                    .fillMaxHeight(0.5f)
                    .fillMaxWidth(),
            ) {
                Cell(0.3f,3,game) {index: Int ->
                    viewModel.ChooseCell(index,{ p=false })
                }
                Cell(0.5f,4,game) {index: Int ->
                    viewModel.ChooseCell(index,{ p=false })
                }
                Cell(1f,5,game) {index: Int ->
                    viewModel.ChooseCell(index,{ p=false })
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(),
            ) {
                Cell(0.3f,6,game){index: Int ->
                    viewModel.ChooseCell(index,{ p=false })
                }
                Cell(0.5f,7,game) {index: Int ->
                    viewModel.ChooseCell(index,{ p=false })
                }
                Cell(1f,8,game){index: Int ->
                    viewModel.ChooseCell(index,{ p=false })
                }
            }
        }
        Divider()

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if(!game.isMyTurn){
                game.chooseCell()
                game.isMyTurn=true
            }
            if(!p){
                p=true
            }
            if(game.finished!=-1 || game.cells_left<=0){
                if(game.finished==-1){
                    Text(text = "Draw!",
                    modifier=Modifier.padding(20.dp))
                }else{
                    var winer="Computer"
                    if(game.finished==0) winer ="You "
                    Text(text = "$winer  won!", Modifier.padding(20.dp))
                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth(0.7f)
                        .padding(20.dp, 5.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(MaterialTheme.colors.primary)
                        .clickable {
                            viewModel.restart()
                            p = !p
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
}

