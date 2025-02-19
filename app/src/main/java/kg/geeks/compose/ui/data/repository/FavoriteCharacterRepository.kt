package kg.geeks.compose.ui.data.repository

import kg.geeks.compose.ui.data.dto.FavoriteCharacter
import kg.geeks.compose.ui.data.dto.FavoriteCharacterDao
import kotlinx.coroutines.flow.Flow

class FavoriteCharacterRepository(
    private val favoriteCharacterDao: FavoriteCharacterDao
) {


    fun getAllFavoriteCharacters(): Flow<List<FavoriteCharacter>> {
        return favoriteCharacterDao.getAllFavoriteCharacters()
    }

    suspend fun addCharacterToFavorites(character: FavoriteCharacter) {
        favoriteCharacterDao.addCharacterToFavorites(character)
    }

    suspend fun removeCharacterFromFavorites(character: FavoriteCharacter) {
        favoriteCharacterDao.removeCharacterFromFavorites(character)
    }
}