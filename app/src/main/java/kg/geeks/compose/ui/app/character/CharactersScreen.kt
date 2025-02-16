package kg.geeks.compose.ui.app.character

import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import kg.geeks.compose.ui.app.viewModel.CharactersViewModel

@Composable
fun CharactersScreen(
    navController: NavController,
    charactersViewModel: CharactersViewModel = viewModel()
) {

    charactersViewModel.fetchAllCharacters()

    val characters = listOf(
        Character(1, "Rick Sanchez", "Alive", "https://example.com/rick.png"),
        Character(2, "Morty Smith", "Alive", "https://example.com/morty.png")
    )

    LazyColumn {
        items(characters) { character ->
            Text(
                text = character.name,
                modifier = Modifier.clickable {
                    navController.navigate("character_detail/${character.id}")
                }
            )
        }
    }
}