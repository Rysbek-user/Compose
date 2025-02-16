package kg.geeks.compose.ui.data.api

import kg.geeks.compose.ui.data.dto.LocationsResultsResponse
import retrofit2.Response
import retrofit2.http.GET

interface LocationApiService {

    @GET("api/location")
    suspend fun fetchAllLocations(): Response<LocationsResultsResponse>
}