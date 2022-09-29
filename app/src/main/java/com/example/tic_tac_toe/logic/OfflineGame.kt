package com.example.tic_tac_toe.logic

import android.util.Log
import com.example.tic_tac_toe.domain.models.Cell
import com.example.tic_tac_toe.domain.models.Game
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class OfflineGame(n: Int){

    var cells_left=9
    var finished=-1
    var myScore:Int =0
    var oppponentScore:Int =0
    var isMyTurn =true
    var grid= listOf<Cell>(Cell(0,-1),Cell(1,-1),Cell(2,-1),Cell(3,-1),Cell(4,-1)
    ,Cell(5,-1),Cell(6,-1),Cell(7,-1),Cell(8,-1),Cell(9,-1))


     fun makeMove(i:Int) {
        grid[i].chooseBy=0
        isMyTurn=!isMyTurn
         cells_left--;
        finished=evaluate()
    }
     fun chooseCell() {
         if(finished==-1){
             runBlocking {
                 delay(500L)
                 for(i in 0..9){
                     if(grid[i].chooseBy==-1){
                         grid[i].chooseBy=1
                         isMyTurn=!isMyTurn
                         cells_left--;
                         finished=evaluate()
                         break
                     }
                 }
             }
         }

    }
     fun evaluate(): Int {
         val m = arrayOf(
             arrayOf(0, 1, 2),
             arrayOf(3, 4, 5),
             arrayOf(6, 7, 8),
             arrayOf(0, 3, 6),
             arrayOf(1, 4, 7),
             arrayOf(2, 5, 8),
             arrayOf(0, 4, 8),
             arrayOf(2, 4, 6)
         )
         for (a in m) {
             if (grid[a[0]].chooseBy == grid[a[1]].chooseBy && grid[a[1]].chooseBy == grid[a[2]].chooseBy && grid[a[0]].chooseBy != -1) {
                 if(grid[a[0]].chooseBy==0) myScore++;
                 else oppponentScore++;
                 
                 var winer=grid[a[0]].chooseBy

                 grid[a[0]].chooseBy=2
                 grid[a[1]].chooseBy=2
                 grid[a[2]].chooseBy=2

                 return winer;
             }
         }
         return -1;
     }
}