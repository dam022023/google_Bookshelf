package com.example.google_bookshelf.data

import com.example.google_bookshelf.model.Book
import com.example.google_bookshelf.network.BooksApiService

interface BooksRepository {
    suspend fun getBooks(): List<Book>
}

class DefaultBooksRepository (
    private val booksApiService: BooksApiService
) : BooksRepository {
    override suspend fun getBooks(): List<Book> = booksApiService.getBooks("")
}