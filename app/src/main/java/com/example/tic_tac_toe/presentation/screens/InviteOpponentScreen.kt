package com.example.tic_tac_toe.presentation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.tic_tac_toe.R
import com.example.tic_tac_toe.presentation.Components.OnlineUserCard

@Composable
fun InviteOpponentScreen(){
    Column(modifier = Modifier.fillMaxSize()){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 0.dp),
            horizontalArrangement = Arrangement.End
        ){
            IconButton(onClick = {
            }){
                Icon(
                    modifier = Modifier.padding(20.dp,15.dp),
                    painter = painterResource(id= R.drawable.ic_baseline_notifications_none_24 ), contentDescription = "notification button")
            }
        }
        val onlineUsers= listOf<String>("moha","boha","noha","kop","hom")

        Divider()

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
        ){
            items(onlineUsers){ c->
                OnlineUserCard(c)
            }
        }


    }
}