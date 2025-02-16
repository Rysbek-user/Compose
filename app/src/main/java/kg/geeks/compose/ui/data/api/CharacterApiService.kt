package kg.geeks.compose.ui.data.api

import kg.geeks.compose.ui.data.dto.CharactersResultsResponse
import retrofit2.Response
import retrofit2.http.GET

interface CharacterApiService {

    @GET("api/character")
    suspend fun feetchAllCharacters(): Response<CharactersResultsResponse>
}