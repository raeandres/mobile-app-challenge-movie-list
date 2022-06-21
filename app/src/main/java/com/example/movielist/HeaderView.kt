package com.example.movielist

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun HeaderView() {
    val currentContext = LocalContext.current
    TopAppBar(
        title = { Text(text = "Film List") },
        backgroundColor = Color.White,
        actions = {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "back",
                tint = Color.Black,
                modifier = Modifier
                    .clickable {
                        Toast.makeText(currentContext, "Avatar Clicked!", Toast.LENGTH_LONG).show()
                    }
                    .padding(
                    start = 0.dp,
                    end = 20.dp,
                    top = 0.dp,
                    bottom = 0.dp
                )
            )
        }
    )
}


@Preview(showBackground = true)
@Composable
fun showHeaderView(){
    HeaderView()
}