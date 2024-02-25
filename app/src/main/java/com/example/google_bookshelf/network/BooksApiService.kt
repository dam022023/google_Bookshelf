package com.example.google_bookshelf.network

import com.example.google_bookshelf.model.Book
import retrofit2.http.GET
import retrofit2.http.Query

interface BooksApiService {
    @GET("volumes")
    suspend fun getBooks(@Query("q") query: String): List<Book>
}