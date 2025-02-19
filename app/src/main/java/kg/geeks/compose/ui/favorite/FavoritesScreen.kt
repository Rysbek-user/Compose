package kg.geeks.compose.ui.favorite

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kg.geeks.compose.ui.viewModule.FavoriteCharacterViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun FavoritesScreen(navController: NavController) {
    val favoriteCharacterViewModel: FavoriteCharacterViewModel = koinViewModel()
    val favoriteCharacters = favoriteCharacterViewModel.favoriteCharacters.collectAsState().value

    LazyColumn {
        if (favoriteCharacters.isEmpty()) {
            item { Text(text = "Нет избранных персонажей") }
        } else {
            items(favoriteCharacters) { character ->
                FavoriteCharacterItem(character, favoriteCharacterViewModel)
            }
        }
    }
}

@Composable
fun FavoriteCharacterItem(character: FavoriteCharacter, viewModel: FavoriteCharacterViewModel) {
    Card(
        modifier = Modifier.padding(8.dp).fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(text = character.name)
            }
            IconButton(onClick = { viewModel.removeCharacterFromFavorites(character) }) {
                Icon(Icons.Default.Delete, contentDescription = "Удалить из избранного")
            }
        }
    }
}