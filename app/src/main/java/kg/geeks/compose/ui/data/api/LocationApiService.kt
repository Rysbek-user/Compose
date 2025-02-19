package kg.geeks.compose.ui.data.api

import kg.geeks.compose.ui.data.dto.LocationResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface LocationApiService {
    @GET("locations")
    suspend fun getLocations(): Response<LocationResponse>

    @GET("location_detail/{id}")
    suspend fun getLocationDetails(@Path("id") id: Int): Response<LocationResponse.Location>
}