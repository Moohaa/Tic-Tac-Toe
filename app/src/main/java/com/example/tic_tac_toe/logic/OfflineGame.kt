package com.example.tic_tac_toe.logic

import android.util.Log
import com.example.tic_tac_toe.domain.models.Cell
import com.example.tic_tac_toe.domain.models.Game
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class OfflineGame(n: Int){

    var m=9

    var myScore:Int =0
    var oppponentScore:Int =0
    var isMyTurn =true
    var grid= listOf<Cell>(Cell(0,-1),Cell(1,-1),Cell(2,-1),Cell(3,-1),Cell(4,-1)
    ,Cell(5,-1),Cell(6,-1),Cell(7,-1),Cell(8,-1),Cell(9,-1))


     fun makeMove(i:Int) {
        grid[i].chooseBy=0
        isMyTurn=!isMyTurn
         m--
    }
     fun chooseCell() {
        runBlocking {
            delay(500L)
            for(i in 0..9){
                if(grid[i].chooseBy==-1){
                    grid[i].chooseBy=1
                    isMyTurn=!isMyTurn
                    m--
                    break
                }
            }
        }
    }
     fun evaluate(): Int {
        if(grid[0].chooseBy==0 && grid[1].chooseBy==0 && grid[2].chooseBy==0) return 0;
        if(grid[3].chooseBy==1 && grid[4].chooseBy==1 && grid[5].chooseBy==1) return 1;
        // no one won
        return -1
    }

     fun isEnded(): Boolean {
        for(i in 0..9){
            if(grid[i].chooseBy==-1) return false
        }
        return true
    }
}