package com.example.google_bookshelf.network

import com.example.google_bookshelf.model.BookSearchResponse
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.converter.gson.GsonConverterFactory

interface BooksApiService {
    @GET("volumes")
    suspend fun getBooks(@Query("q") query: String): BookSearchResponse
}

object RetrofitInstance {
    private const val BASE_URL = "https://www.googleapis.com/books/v1/"

    val retrofitService: BooksApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(BooksApiService::class.java)
    }
}