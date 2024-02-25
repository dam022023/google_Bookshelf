package com.example.google_bookshelf.model

import kotlinx.serialization.Serializable

@Serializable
data class Book (
    val title: String? = null,
    val authors: List<String>? = null,
    val imageLinks: ImageLinks? = null,
    val publisher: String? = null,
    val publishedDate: String? = null
)

data class ImageLinks(
    val thumbnail: String? = null
)