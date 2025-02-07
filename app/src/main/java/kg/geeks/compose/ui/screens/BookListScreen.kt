package kg.geeks.compose.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kg.geeks.compose.data.Book
import kg.geeks.compose.data.SampleData
import kg.geeks.compose.ui.components.BookItem
import kg.geeks.compose.ui.components.CategoryFilter
import kg.geeks.compose.ui.components.SearchBar

@Composable
fun BookListScreen(onBookClick: (Book) -> Unit) {
    var searchQuery by remember { mutableStateOf("") }
    var selectedCategory by remember { mutableStateOf("Все") }

    val filteredBooks = SampleData.books.filter { book ->
        (selectedCategory == "Все" || book.category == selectedCategory) &&
                (searchQuery.isBlank() || book.title.contains(searchQuery, ignoreCase = true) ||
                        book.author.contains(searchQuery, ignoreCase = true))
    }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        SearchBar(searchQuery) { searchQuery = it }
        Spacer(modifier = Modifier.height(8.dp))
        CategoryFilter(SampleData.categories, selectedCategory) { selectedCategory = it }
        Spacer(modifier = Modifier.height(8.dp))

        LazyColumn {
            items(filteredBooks) { book ->
                BookItem(book, onClick = { onBookClick(book) })
            }
        }
    }
}