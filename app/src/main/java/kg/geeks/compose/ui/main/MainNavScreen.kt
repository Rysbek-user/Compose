package kg.geeks.compose.ui.main

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kg.geeks.compose.ui.app.AppBottomBar
import kg.geeks.compose.ui.app.AppTopBar
import kg.geeks.compose.ui.screens.CharacterDetailScreen
import kg.geeks.compose.ui.screens.CharactersScreen
import kg.geeks.compose.ui.screens.EpisodeDetailScreen
import kg.geeks.compose.ui.screens.EpisodesScreen
import kg.geeks.compose.ui.screens.LocationDetailScreen
import kg.geeks.compose.ui.screens.LocationsScreen

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
                composableWithTransitions("characters") { CharactersScreen(navController) }
                composableWithTransitions("locations") { LocationsScreen(navController) }
                composableWithTransitions("episodes") { EpisodesScreen(navController) }
                composableWithTransitions("character_detail/{characterId}") { backStackEntry ->
                    val characterId = backStackEntry.arguments?.getString("characterId")?.toIntOrNull()
                    if (characterId != null) {
                        CharacterDetailScreen(characterId)
                    }
                }
                composableWithTransitions("location_detail/{locationId}") { backStackEntry ->
                    val locationId = backStackEntry.arguments?.getString("locationId")?.toIntOrNull()
                    if (locationId != null) {
                        LocationDetailScreen(locationId)
                    }
                }
                composableWithTransitions("episode_detail/{episodeId}") { backStackEntry ->
                    val episodeId = backStackEntry.arguments?.getString("episodeId")?.toIntOrNull()
                    if (episodeId != null) {
                        EpisodeDetailScreen(episodeId)
                    }
                }
            }
        }
    }
}

fun NavGraphBuilder.composableWithTransitions(
    route: String,
    content: @Composable AnimatedContentScope.(NavBackStackEntry) -> Unit
) {
    composable(route, content = content)
}