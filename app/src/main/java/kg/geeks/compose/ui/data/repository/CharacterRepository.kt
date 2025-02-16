package kg.geeks.compose.ui.data.repository

import kg.geeks.compose.ui.data.api.CharacterApiService
import kg.geeks.compose.ui.data.dto.CharactersResponse

class CharacterRepository(
    private val apiService: CharacterApiService
) {

    suspend fun fetchAllCharacters():List<CharactersResponse>?{
        val response = apiService.feetchAllCharacters()
        return if (response.isSuccessful) {
            response.body()?.charactersResponse
        }else{
            emptyList()
        }
    }
}