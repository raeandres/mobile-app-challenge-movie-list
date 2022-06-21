package com.example.movielist

import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.movielist.model.Movie
import com.example.movielist.viewmodel.MovieViewModel

@ExperimentalFoundationApi
@Composable
fun MovieCard(vm: MovieViewModel) {

    val currentContext = LocalContext.current

    LaunchedEffect(Unit, block = {
            vm.getMovieList()
        })
    if (vm.errorMessage.isEmpty()) {

        LazyVerticalGrid(
            cells = GridCells.Fixed(2)) {
            items(vm.movies) { movie ->
                Box(
                    contentAlignment = Alignment.BottomStart) {
                    Column(
                        modifier = Modifier
                            .clickable {
                                Toast.makeText(currentContext,movie.Title, Toast.LENGTH_LONG).show()
                            }
                            .padding(10.dp)
                            .clip(RoundedCornerShape(2.dp))
                    ) {
                        Image(
                            painter = rememberAsyncImagePainter(model = movie.Poster),
                            contentDescription = null,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(200.dp)
                                .align(Alignment.Start))
                        Text(
                            text = movie.Title,
                            textAlign = TextAlign.Start,
                            fontSize = 16.sp)
                    }
                }
            }
        }
    }

}

@ExperimentalFoundationApi
@Preview(showBackground = true)
@Composable
fun MovieCardPreview() {
    val movies = mutableListOf(
        Movie(
            Title = "Captain Marvel",
            Year = "2019",
            imdbID = "tt4154664",
            Type = "movie",
            Poster = "https://m.media-amazon.com/images/M/MV5BMTE0YWFmOTMtYTU2ZS00ZTIxLWE3OTEtYTNiYzBkZjViZThiXkEyXkFqcGdeQXVyODMzMzQ4OTI@._V1_SX300.jpg"),
        Movie(
            Title = "Marvel One-Shot: Agent Carter",
            Year = "2013",
            imdbID = "tt3067038",
            Type = "movie",
            Poster = "https://m.media-amazon.com/images/M/MV5BZDIwZTM4M2QtMWFhYy00N2VmLWFlMjItMzI3NjBjYTc0OTMxXkEyXkFqcGdeQXVyNTE1NjY5Mg@@._V1_SX300.jpg"),
        Movie(
            Title = "Marvel One-Shot: All Hail the King",
            Year = "2014",
            imdbID = "tt3438640",
            Type = "movie",
            Poster = "https://m.media-amazon.com/images/M/MV5BZGFkMTZkMDQtNzM4Yy00YWEwLTkzOWEtZTMyNDRlNmJhYWJhXkEyXkFqcGdeQXVyNTE1NjY5Mg@@._V1_SX300.jpg"),
        Movie(
            Title = "Marvel One-Shot: Item 47",
            Year = "2012",
            imdbID = "tt2247732",
            Type = "movie",
            Poster = "https://m.media-amazon.com/images/M/MV5BMjNlMzAxNmQtOGEwZi00NTEyLWI0NWYtMTlhNmE2YTA3ZDVhXkEyXkFqcGdeQXVyNTE1NjY5Mg@@._V1_SX300.jpg"),
        Movie(
            Title = "Marvel One-Shot: A Funny Thing Happened on the Way to Thor's Hammer",
            Year = "2011",
            imdbID = "tt2011109",
            Type = "movie",
            Poster = "https://m.media-amazon.com/images/M/MV5BYmVlYTg3N2QtMWM2OS00YWQyLWI2M2MtMDc0ZjBkZjk1MTY3XkEyXkFqcGdeQXVyNTE1NjY5Mg@@._V1_SX300.jpg"),
        Movie(
            Title = "Marvel One-Shot: The Consultant",
            Year = "2011",
            imdbID = "tt2011118",
            Type = "movie",
            Poster = "https://m.media-amazon.com/images/M/MV5BNGE4YjU5MDAtYzYzMC00M2RlLTk0NDgtNDU1MjgyMGI0MjI3XkEyXkFqcGdeQXVyNTE1NjY5Mg@@._V1_SX300.jpg"),
        Movie(
            Title = "Marvel Studios: Assembling a Universe",
            Year = "2014",
            imdbID = "tt3591568",
            Type = "movie",
            Poster = "https://m.media-amazon.com/images/M/MV5BZjNiN2NhYzQtYmI1NC00NGRmLWE2MWYtNjAxNjMzZmYxNDJhXkEyXkFqcGdeQXVyODQ4MjU1MDk@._V1_SX300.jpg"),
        Movie(
            Title = "Adventures of Captain Marvel",
            Year = "1941",
            imdbID = "tt0033317",
            Type = "movie",
            Poster = "https://m.media-amazon.com/images/M/MV5BNjg0NTk3NjUyNF5BMl5BanBnXkFtZTgwNDQ5MjM1MjE@._V1_SX300.jpg"),
        Movie(
            Title = "Pokémon the Movie: Volcanion and the Mechanical Marvel",
            Year = "2016",
            imdbID = "tt5889204",
            Type = "movie",
            Poster = "https://m.media-amazon.com/images/M/MV5BZTUwZDEzZGEtYTJlYi00OTRkLWJmMzItODU0ZWViMTUyYjUzXkEyXkFqcGdeQXVyNzEyMDQ1MDA@._V1_SX300.jpg"),
        Movie(
            Title = "Marvel Rising: Secret Warriors",
            Year = "2018",
            imdbID = "tt7728344",
            Type = "movie",
            Poster = "https://m.media-amazon.com/images/M/MV5BZGU5YTVlZTktNzgzMS00MGVlLTgyMGMtNWYwNTkwNGY1MzllXkEyXkFqcGdeQXVyNTAyODkwOQ@@._V1_SX300.jpg")
    )
    val movieVm = MovieViewModel()
    movieVm._movieList.addAll(movies)
    MovieCard(vm = movieVm)
}