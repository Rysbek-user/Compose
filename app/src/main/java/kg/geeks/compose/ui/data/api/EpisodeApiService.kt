package kg.geeks.compose.ui.data.api

import kg.geeks.compose.ui.app.episode.Episode
import kg.geeks.compose.ui.app.episode.EpisodeResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface EpisodeApiService {
    @GET("episodes")
    suspend fun getEpisodes(): Response<EpisodeResponse>

    @GET("episode_detail/{id}")
    suspend fun getEpisodeDetails(@Path("id") id: Int): Response<Episode>
}