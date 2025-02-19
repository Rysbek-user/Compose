package kg.geeks.compose.ui.favorite

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun FavoriteCharacterDetailScreen(characterId: Int, onBack: () -> Unit) {
    Text(text = " ID: $characterId")
}