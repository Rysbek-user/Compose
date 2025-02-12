package kg.geeks.compose.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun EpisodesScreen(navController: NavController) {
    val episodes = listOf(
        Episode(1, "Pilot"),
        Episode(2, "Lawn Mower Dog")
    )

    LazyColumn {
        items(episodes) { episode ->
            Text(
                text = episode.title,
                modifier = Modifier.clickable {
                    navController.navigate("episode_detail/${episode.id}")
                }
            )
        }
    }
}