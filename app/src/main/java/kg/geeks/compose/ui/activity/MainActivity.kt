package kg.geeks.compose.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import kg.geeks.compose.data.Book
import kg.geeks.compose.ui.screens.BookDetailScreen
import kg.geeks.compose.ui.screens.BookListScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var selectedBook by remember { mutableStateOf<Book?>(null) }

            if (selectedBook == null) {
                BookListScreen { book -> selectedBook = book }
            } else {
                BookDetailScreen(selectedBook!!) { selectedBook = null }
            }
        }
    }
}