package com.example.google_bookshelf.ui.screens

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.google_bookshelf.model.Book
import com.example.google_bookshelf.network.RetrofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

sealed interface BooksUiState {
    data class Success(val amphibians: List<Book>) : BooksUiState
    object Error : BooksUiState
    object Loading : BooksUiState
}

class BooksViewModel  : ViewModel() {

    private val _bookSearch = MutableLiveData<String>()
    val bookSearch: LiveData<String> = _bookSearch

    private val _books = MutableStateFlow<List<Book>>(emptyList())
    val books: StateFlow<List<Book>> = _books

    fun getBooks(query: String) {
        viewModelScope.launch {
            val response =
                RetrofitInstance.retrofitService.getBooks(query)
            _books.value = response.items!!
        }

    }

    fun clearBookSearch(query: String) {
        _bookSearch.value = query
    }
}