package kg.geeks.compose.ui.data.repository

import kg.geeks.compose.ui.data.api.EpisodeApiService
import kg.geeks.compose.ui.data.dto.EpisodesResponse

class EpisodeRepository(
    private val apiService: EpisodeApiService
) {

    suspend fun fetchAllEpisodes(): List<EpisodesResponse>? {
        val response = apiService.fetchAllEpisodes()
        return if (response.isSuccessful) {
            response.body()?.episodesResponse
        } else {
            emptyList()
        }
    }
}