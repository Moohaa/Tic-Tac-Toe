package com.example.tic_tac_toe.presentation.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.tic_tac_toe.R

@Composable
fun OnlineUserCard(
    userName :String
){
    Row(modifier = Modifier
        .fillMaxWidth()
        .clickable { },
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        Row(
            modifier=Modifier.fillMaxWidth(0.7f),
            verticalAlignment = Alignment.CenterVertically
        ){
            Icon(
                modifier = Modifier
                    .padding(20.dp,0.dp).size(40.dp),
                painter = painterResource(id= R.drawable.ic_baseline_account_circle_24), contentDescription = "notification button")

            Text(text = userName)
        }
        Button(
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .padding(7.dp),
            onClick = {
        }){
            Text(text = "Invite")
        }
    }
    Divider()

}