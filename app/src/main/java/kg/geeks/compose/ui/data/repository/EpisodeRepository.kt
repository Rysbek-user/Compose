package kg.geeks.compose.ui.data.repository

import kg.geeks.compose.ui.data.api.EpisodeApiService

class EpisodeRepository(private val episodeApiService: EpisodeApiService) {

    suspend fun getEpisodes() = episodeApiService.getEpisodes()

    suspend fun getEpisodeDetails(id: Int) = episodeApiService.getEpisodeDetails(id)
}