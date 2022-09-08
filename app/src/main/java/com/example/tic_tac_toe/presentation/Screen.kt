package com.example.tic_tac_toe.presentation

sealed class Screen(val route :String){
    object OptionScreen : Screen("optionScreen")
    object GameScreen : Screen("game_screen")
    object LoginScreen : Screen("login")
    object SignUpScreen : Screen("signUp")
    object SplashScreen : Screen("splash")
    object InviteOpponent : Screen("inviteOpponent")
}
