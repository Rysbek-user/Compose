package kg.geeks.compose.ui.app.episode

import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import kg.geeks.compose.ui.app.viewModel.EpisodeViewModel
import kg.geeks.compose.ui.data.dto.EpisodesResponse

@Composable
fun EpisodesScreen(navController: NavController, episodeViewModel: EpisodeViewModel = viewModel()) {
    episodeViewModel.fetchAllEpisodes()

    val episodes = listOf(
        EpisodesResponse(1, "Pilot", "S01E01", "https://example.com/episode1.jpg"),
        EpisodesResponse(2, "Lawnmower Dog", "S01E02", "https://example.com/episode2.jpg"))

    LazyColumn {
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