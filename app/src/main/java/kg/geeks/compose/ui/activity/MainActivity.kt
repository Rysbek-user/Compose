package kg.geeks.compose.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import kg.geeks.compose.ui.favorite.FavoriteCharacterDetailScreen
import kg.geeks.compose.ui.favorite.FavoritesScreen
import kg.geeks.compose.ui.modul.Screen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
                App()
        }
    }
}

@Composable
fun App() {
    val navController = rememberNavController()

    Scaffold(
        topBar = {
            when (navController.currentBackStackEntry?.destination?.route) {
                Screen.Characters.route -> AppTopBar("Characters", isDetailScreen = false)
                Screen.Locations.route -> AppTopBar("Locations", isDetailScreen = false)
                Screen.Episodes.route -> AppTopBar("Episodes", isDetailScreen = false)
                Screen.Favorites.route -> AppTopBar("Favorites", isDetailScreen = false)
                else -> AppTopBar("", isDetailScreen = true, onBack = { navController.popBackStack() })
            }
        },
        bottomBar = {
            if (navController.currentBackStackEntry?.destination?.route !in listOf(
                    Screen.CharacterDetail.route,
                    "location_detail/{id}",
                    "episode_detail/{id}"
                )
            ) {
                AppBottomBar(navController)
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Characters.route,
            Modifier.padding(innerPadding)
        ) {
            composable(Screen.Characters.route) { CharactersScreen(navController) }
            composable(Screen.CharacterDetail.route) { backStackEntry ->
                val characterId =
                    backStackEntry.arguments?.getString("characterId")?.toInt() ?: 0
                CharacterDetailScreen(characterId) { navController.popBackStack() }
            }
            composable(Screen.Locations.route) { LocationsScreen(navController) }
            composable("location_detail/{id}") { backStackEntry ->
                val locationId = backStackEntry.arguments?.getString("id")?.toIntOrNull() ?: 0
                LocationDetailScreen(locationId)
            }
            composable(Screen.Episodes.route) { EpisodesScreen(navController) }
            composable("episode_detail/{id}") { backStackEntry ->
                val episodeId = backStackEntry.arguments?.getString("id")?.toInt() ?: 0
                EpisodeDetailScreen(episodeId)
            }
            composable(Screen.Favorites.route) { FavoritesScreen(navController) }
            composable("favorite_character_detail/{id}") { backStackEntry ->
                val characterId = backStackEntry.arguments?.getString("id")?.toInt() ?: 0
                FavoriteCharacterDetailScreen(characterId) { navController.popBackStack() }
            }
        }
    }
}