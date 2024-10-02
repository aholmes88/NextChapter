package com.example.nextchapter.data

data class BookResponse(
    val items: List<Book>
)

data class VolumeInfo(
    val title: String,
    val authors: List<String>,
    val description: String,
    val thumbnail: String,
    val imageLinks: ImageLinks,
)

data class Book(
    val volumeInfo: VolumeInfo
)

data class ImageLinks(
    val thumbnail: String
)

data class BookCategory(
    val name: String, val coverUrl: String
)

val bookCategories = listOf(
    BookCategory(
        name = "Romance",
        coverUrl = "https://m.media-amazon.com/images/I/615ZIxEDozL._AC_UF1000,1000_QL80_.jpg"
    ), BookCategory(
        name = "Horror",
        coverUrl = "https://m.media-amazon.com/images/I/91z7UtJ+tFL._AC_UF1000,1000_QL80_.jpg"
    ), BookCategory(
        name = "Comedy",
        coverUrl = "https://m.media-amazon.com/images/I/81R2N4PRuUL._AC_UF1000,1000_QL80_.jpg",
    ), BookCategory(
        name = "Science",
        coverUrl = "https://m.media-amazon.com/images/I/71Xj4JZwHnL._AC_UF1000,1000_QL80_.jpg",
    ), BookCategory(
        name = "Manga",
        coverUrl = "https://m.media-amazon.com/images/I/81qPzeEO5IL._AC_UF1000,1000_QL80_.jpg"
    ), BookCategory(
        name = "Business",
        coverUrl = "https://m.media-amazon.com/images/I/71W57+-AtnL._AC_UF1000,1000_QL80_.jpg"
    )
)