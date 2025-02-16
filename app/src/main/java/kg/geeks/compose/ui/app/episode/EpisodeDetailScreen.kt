package kg.geeks.compose.ui.app.episode

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun EpisodeDetailScreen(episodeId: Int) {
    Text(text = "Episode Details for Episode #$episodeId")
}