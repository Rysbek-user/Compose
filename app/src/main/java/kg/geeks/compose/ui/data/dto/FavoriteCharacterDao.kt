package kg.geeks.compose.ui.data.dto

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import kotlinx.coroutines.flow.Flow
import androidx.room.Query

@Dao
interface FavoriteCharacterDao {
    @Insert
    suspend fun addCharacterToFavorites(character: FavoriteCharacter)

    @Delete
    suspend fun removeCharacterFromFavorites(character: FavoriteCharacter)

    @Query("SELECT * FROM favorite_characters")
    fun getAllFavoriteCharacters(): Flow<List<FavoriteCharacter>>
}