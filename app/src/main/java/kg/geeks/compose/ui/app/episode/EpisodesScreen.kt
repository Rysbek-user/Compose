package kg.geeks.compose.ui.app.episode

import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import kg.geeks.compose.ui.viewModule.EpisodeViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun EpisodesScreen(navController: NavController) {
    val episodeViewModel: EpisodeViewModel = koinViewModel()
    val episodes = episodeViewModel.episodes.collectAsState().value

    LazyColumn {
        if (episodes.isEmpty()) {
            item { Text(text = "Загрузка...") }
        } else {
            items(episodes) { episode ->
                Text(
                    text = episode.name,
                    modifier = Modifier.clickable {
                        navController.navigate("episode_detail/${episode.id}")
                    }
                )
            }
        }
    }
}