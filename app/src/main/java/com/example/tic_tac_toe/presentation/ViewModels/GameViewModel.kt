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
    fun restart(){
        for(item in game.grid){
            item.chooseBy=-1
            game.isMyTurn=true
        }
    }
}