package kg.geeks.compose.ui.data.api

import kg.geeks.compose.ui.data.dto.EpisodesResultsResponse
import retrofit2.Response
import retrofit2.http.GET

interface EpisodeApiService {

    @GET("api/episode")
    suspend fun fetchAllEpisodes(): Response<EpisodesResultsResponse>
}