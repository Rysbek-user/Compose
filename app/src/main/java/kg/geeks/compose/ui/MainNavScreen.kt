package kg.geeks.compose.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kg.geeks.compose.ui.app.character.CharacterDetailScreen
import kg.geeks.compose.ui.app.character.CharactersScreen
import kg.geeks.compose.ui.app.episode.EpisodeDetailScreen
import kg.geeks.compose.ui.app.episode.EpisodesScreen
import kg.geeks.compose.ui.app.location.LocationDetailScreen
import kg.geeks.compose.ui.app.location.LocationsScreen
import kg.geeks.compose.ui.app.navigation.AppBottomBar
import kg.geeks.compose.ui.app.navigation.AppTopBar

@Composable
fun MainNavScreen() {
    val navController = rememberNavController()

    Scaffold(
        topBar = { AppTopBar(navController) },
        bottomBar = { AppBottomBar(navController) }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            NavHost(
                navController = navController,
                startDestination = "characters"
            ) {
                composable("characters") { CharactersScreen(navController) }
                composable("locations") { LocationsScreen(navController) }
                composable("episodes") { EpisodesScreen(navController) }
                composable("character_detail/{characterId}") { backStackEntry ->
                    val characterId = backStackEntry.arguments?.getString("characterId")?.toIntOrNull()
                    if (characterId != null) {
                        CharacterDetailScreen(characterId)
                    }
                }
                composable("location_detail/{locationId}") { backStackEntry ->
                    val locationId = backStackEntry.arguments?.getString("locationId")?.toIntOrNull()
                    if (locationId != null) {
                        LocationDetailScreen(locationId)
                    }
                }
                composable("episode_detail/{episodeId}") { backStackEntry ->
                    val episodeId = backStackEntry.arguments?.getString("episodeId")?.toIntOrNull()
                    if (episodeId != null) {
                        EpisodeDetailScreen(episodeId)
                    }
                }
            }
        }
    }
}