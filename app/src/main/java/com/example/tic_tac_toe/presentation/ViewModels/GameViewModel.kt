package com.example.tic_tac_toe.presentation.ViewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.tic_tac_toe.logic.OfflineGame
import dagger.hilt.android.lifecycle.HiltViewModel

class GameViewModel :ViewModel() {
    var isinit=false
    var a=OfflineGame(9)
    val game:OfflineGame
        get() {
            if(!isinit){
                isinit=true
                a=OfflineGame(9)
            }
            return a
        }
    fun ChooseCell(index: Int,update :()->Unit){
        if (game.isMyTurn && game.grid[index].chooseBy==-1){
            game.makeMove(index)
            game.isMyTurn=false
            update()
        }

    }
    fun restart(){
        game.finished=-1
        game.cells_left=9
        for(item in game.grid){
            item.chooseBy=-1
        }
    }
}