package com.example.movielist

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.movielist.viewmodel.MovieViewModel

@ExperimentalFoundationApi
@Composable
fun MovieCard(vm: MovieViewModel) {

    LaunchedEffect(Unit, block = {
            vm.getMovieList()
        })
    Scaffold(
        content = {
            if (vm.errorMessage.isEmpty()) {

                LazyVerticalGrid(
                    cells = GridCells.Fixed(2)) {
                    items(vm.movies) { movie ->
                        Box(
                            contentAlignment = Alignment.Center) {
                            Column(
                                modifier = Modifier
                                    .padding(8.dp)
                                    .aspectRatio(1f)
                                    .clip(RoundedCornerShape(2.dp))
                            ) {
                                Image(
                                    painter = rememberAsyncImagePainter(model = movie.Poster),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(100.dp))
                                Text(
                                    text = movie.Title,
                                    textAlign = TextAlign.Start,
                                    modifier = Modifier.align(Alignment.Start))
                            }
                        }
                    }
                }
            }
        }
    )

}