package kg.geeks.compose.ui.data.dto

import com.google.gson.annotations.SerializedName

data class EpisodesResultsResponse(
    @SerializedName("results")
    val episodesResponse: List<EpisodesResponse>
)

data class EpisodesResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("air_date")
    val airDate: String,
    @SerializedName("episode")
    val episode: String
)