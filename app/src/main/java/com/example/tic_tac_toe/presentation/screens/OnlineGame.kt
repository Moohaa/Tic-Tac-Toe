package com.example.tic_tac_toe.presentation.screens

import androidx.compose.foundation.background
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.tic_tac_toe.R
import com.example.tic_tac_toe.presentation.Components.Cell
import com.example.tic_tac_toe.presentation.Components.OpponentBar
import com.example.tic_tac_toe.presentation.Components.PlayerBar
import com.example.tic_tac_toe.presentation.Components.ScoreBoard
import com.example.tic_tac_toe.presentation.ViewModels.GameViewModel

@Composable
fun OnlineGame(
    viewModel: GameViewModel = hiltViewModel()
){
    var game =viewModel.game
    Column(
        modifier = Modifier.fillMaxSize(),
    ){
        Row(
            modifier =Modifier.fillMaxWidth(),

            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            PlayerBar(userName = "Player 1", game = game)
            ScoreBoard(player1Score = 10, player2Score = 9)
            OpponentBar(userName = "Player 2", game = game)
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
                    Text(text = "draw!")
                }else{
                    var winer="Computer"
                    if(game.finished==0) winer ="you "
                    Text(text = "$winer  won!")
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

