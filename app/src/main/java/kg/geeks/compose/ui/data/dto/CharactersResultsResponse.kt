package kg.geeks.compose.ui.data.dto

import com.google.gson.annotations.SerializedName

data class CharacterResultResponse(
    @SerializedName("results")
    val result: List<CharacterResponse>
)

data class CharacterResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("species")
    val species: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("location")
    val location: LocationResponse

)
data class LocationResponse(
    @SerializedName("results")
    val results: List<Location>
) {
    data class Location(
        @SerializedName("id")
        val id: Int,
        @SerializedName("name")
        val name: String,
        @SerializedName("type")
        val type: String,
        @SerializedName("dimension")
        val dimension: String,
        @SerializedName("residents")
        val residents: List<String>
    )
}

data class EpisodeResponse(
    @SerializedName("results")
    val results: List<Episode>
) {
    data class Episode(
        @SerializedName("id")
        val id: Int,
        @SerializedName("name")
        val name: String,
        @SerializedName("air_date")
        val airDate: String,
        @SerializedName("episode")
        val episode: String,
        @SerializedName("characters")
        val characters: List<String>
    )
}

data class FavoriteCharacter(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("imageUrl")
    val imageUrl: String
)