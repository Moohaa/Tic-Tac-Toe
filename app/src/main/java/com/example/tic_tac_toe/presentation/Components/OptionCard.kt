package com.example.tic_tac_toe.presentation.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun OptionCard(
    text:String,
    navigate :()->Unit
) {
    Box(
        modifier = Modifier.fillMaxWidth()
        .padding(20.dp,5.dp)
        .background(MaterialTheme.colors.secondary)
        .clip(RoundedCornerShape(10.dp))
        .clickable {
            navigate()
        },
        Alignment.Center,
    ){
        Text(
            text = text,
            modifier = Modifier.padding(20.dp),
            textAlign = TextAlign.Center
        )
    }
}