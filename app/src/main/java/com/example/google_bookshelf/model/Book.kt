package com.example.google_bookshelf.model

data class BookSearchResponse(
    val items: List<Book>? = null
)

data class Book(
    val volumeInfo: VolumeInfo? = null
)

data class VolumeInfo(
    val title: String? = null,
    val authors: List<String>? = null,
    val imageLinks: ImageLinks? = null,
    val publisher: String? = null,
    val publishedDate: String? = null
)

data class ImageLinks(
    val thumbnail: String? = null
) {
    val httpsThumbnail: String? get() = thumbnail?.replace("http", "https")
}