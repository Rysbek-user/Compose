package kg.geeks.compose.ui.data.repository

import kg.geeks.compose.ui.data.api.LocationApiService
import kg.geeks.compose.ui.data.dto.LocationsResponse

class LocationRepository(
    private val apiService: LocationApiService
) {

    suspend fun fetchAllLocations(): List<LocationsResponse>? {
        val response = apiService.fetchAllLocations()
        return if (response.isSuccessful) {
            response.body()?.locationsResponse
        } else {
            emptyList()
        }
    }
}