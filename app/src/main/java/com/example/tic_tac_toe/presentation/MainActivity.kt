package com.example.tic_tac_toe.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tic_tac_toe.presentation.screens.*
import com.example.tic_tac_toe.presentation.theme.Tic_Tac_ToeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Tic_Tac_ToeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController, startDestination = Screen.OptionScreen.route) {
                        composable(Screen.OptionScreen.route){ OptionsScreen(navController)}
                        composable(Screen.SplashScreen.route){ SplashScreen()}
                        composable(Screen.GameScreen.route){ GameScreen()}
                        composable(Screen.LoginScreen.route){ Login(navController = navController)}
                        composable(Screen.SignUpScreen.route){ SignUp(navController = navController) }
                        composable(Screen.InviteOpponent.route){ InviteOpponentScreen(navController=navController) }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(
        text = "Hello $name!",
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Tic_Tac_ToeTheme {
        Greeting("Android")
    }
}