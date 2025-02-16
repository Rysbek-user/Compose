package kg.geeks.compose.ui.data.dto

import com.google.gson.annotations.SerializedName

data class LocationsResultsResponse(
    @SerializedName("results")
    val locationsResponse: List<LocationsResponse>
)

data class LocationsResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("dimension")
    val dimension: String,
    @SerializedName("type")
    val type: String
)