package kg.geeks.compose.ui.app.character

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun CharacterDetailScreen(characterId: Int) {
    Text(text = "Character Details for Character #$characterId")
}