package com.example.google_bookshelf.ui.screens

import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.google_bookshelf.R
import com.example.google_bookshelf.model.Book
import coil.compose.rememberImagePainter



@Composable
fun GoogleBooksResult(books: List<Book>) {
    LazyColumn {
        items(books) { book ->
            ResultCards(book = book)
        }
    }
}

@Composable
fun ResultCards(book: Book, modifier: Modifier = Modifier) {
    Card () {
        book.imageLinks?.thumbnail?.let { thumbnailUrl ->
            Text(
                text = book.title?: " ",
                fontSize = 8.sp,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(2.dp)
            )
            Text(
                text = book.authors?.firstOrNull() ?: " ",
                fontSize = 6.sp,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(2.dp)
            )
            Image(
                painter = rememberImagePainter(data = thumbnailUrl),
                contentDescription = null
            )
            Text(
                text = book.publisher?: " ",
                fontSize = 6.sp,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(2.dp),
                fontWeight = FontWeight.Light
            )
        }
    }
}