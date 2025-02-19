package kg.geeks.compose.ui.app.character

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import kg.geeks.compose.ui.viewModule.CharacterViewModule
import org.koin.androidx.compose.koinViewModel

@Composable
fun CharacterDetailScreen(characterId: Int, onBack: () -> Unit) {
    val characterViewModel: CharacterViewModule = koinViewModel()

    LaunchedEffect(characterId) {
        characterViewModel.getCharacterDetails(characterId)
    }

    val character = characterViewModel.characterDetails.collectAsState().value

    if (character == null) {
        Text(text = "Загрузка...")
    } else {
        Column {
            Image(
                painter = rememberImagePainter(character.image),
                contentDescription = null,
                modifier = Modifier.size(200.dp)
            )
            Text(text = character.name)
            Text(text = "Status: ${character.status}")
            Button(onClick = onBack) {
                Text(text = "Назад")
            }
        }
    }
}