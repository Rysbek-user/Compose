package kg.geeks.compose.ui.modul

sealed class Screen(val route: String) {
    object Characters : Screen("characters")
    object CharacterDetail : Screen("characterDetail/{characterId}") {
        fun createRoute(characterId: Int) = "characterDetail/$characterId"
    }
    object Locations : Screen("locations")
    object Episodes : Screen("episodes")
    object Favorites : Screen("favorites")
}