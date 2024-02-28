package com.example.google_bookshelf.ui.screens

import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.google_bookshelf.model.Book
import coil.request.ImageRequest

@Composable
fun GoogleBooksResult(viewModel: BooksViewModel) {
    val books by viewModel.books.collectAsState(initial = emptyList())
    LazyColumn {
        items(books) { book ->
            ResultCards(book = book)
        }
    }
}

@Composable
fun ResultCards(book: Book, modifier: Modifier = Modifier) {
    Card(
        modifier= Modifier.padding(15.dp)
    ) {
        Text(
            text = book.volumeInfo?.title ?: " ",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(2.dp)
        )
        Text(
            text = book.volumeInfo?.authors?.firstOrNull() ?: " ",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(2.dp)
        )
        book.volumeInfo?.imageLinks?.httpsThumbnail?.let { thumbnailUrl ->
            AsyncImage(
                modifier = Modifier
                    .aspectRatio(0.9f)
                    .size(100.dp),
                model = ImageRequest.Builder(context = LocalContext.current)
                    .data(thumbnailUrl)
                    .build(),
                contentDescription = null,
                contentScale = ContentScale.FillBounds
            )
        }
        Text(
            text = book.volumeInfo?.publisher ?: " ",
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(2.dp),
            fontWeight = FontWeight.Light
        )
    }
}
