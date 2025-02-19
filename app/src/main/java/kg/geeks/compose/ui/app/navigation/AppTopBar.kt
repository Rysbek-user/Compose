package kg.geeks.compose.ui.app.navigation

import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable


@Composable
fun AppTopBar(title: String, isDetailScreen: Boolean, onBack: (() -> Unit)? = null) {
    if (!isDetailScreen) {
        TopAppBar(title = { Text(title) })
    } else {
        TopAppBar(
            title = { Text(title) },
            navigationIcon = {
                IconButton(onClick = { onBack?.invoke() }) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                }
            }
        )
    }
}