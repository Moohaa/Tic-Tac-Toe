package com.example.tic_tac_toe.domain.models

abstract class Game{
    abstract fun makeMove(i:Int): Unit
    abstract fun chooseCell(): Int
    abstract fun evaluate(): Int
    abstract fun isEnded():Boolean
}
