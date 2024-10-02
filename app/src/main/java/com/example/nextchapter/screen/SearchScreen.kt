package com.example.nextchapter.screen



import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import coil.transform.RoundedCornersTransformation
import coil.util.DebugLogger
import com.example.nextchapter.data.Book


import com.example.nextchapter.viewmodel.SearchViewModel


@Composable
fun SearchScreen (query:String, searchViewModel: SearchViewModel){
    LaunchedEffect(key1 = query) {
        searchViewModel.searchBooks(query)
    }

    val searchState by searchViewModel.bookState

    Column ( modifier = Modifier. fillMaxSize().padding(16.dp)){
        Text("Search Results for ${query}", fontSize = 24.sp)

        when{
            searchState .loading ->{
                CircularProgressIndicator()
            }
            searchState.error != null ->{
                Text(text = searchState.error ?:"Unkown Error")
            }
            searchState.booklist.isNotEmpty()->
            {
                LazyColumn {
                    items(searchState.booklist){}
                }
            }        }
    }
}

@Composable
fun BookItem(book: Book) {
    val imageUrl = book.volumeInfo.imageLinks?.thumbnail

    // Create a custom ImageLoader for debugging
    val imageLoader = ImageLoader.Builder(LocalContext.current)
        .logger(DebugLogger())
        .error(android.R.drawable.ic_menu_report_image) // Fallback image if error
        .build()

    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(book.volumeInfo.title)
        Image(
            painter = rememberAsyncImagePainter(
                ImageRequest.Builder(LocalContext.current)
                    .data(imageUrl)
                    .size(Size.ORIGINAL) // Fetch the original size
                    .crossfade(true).transformations(RoundedCornersTransformation(8f))
                    .build(),
                imageLoader = imageLoader
            ),
            contentDescription = book.volumeInfo.title,
            modifier = Modifier
                .size(200.dp)
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )

    }
}