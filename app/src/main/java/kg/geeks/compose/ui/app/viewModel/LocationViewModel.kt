package kg.geeks.compose.ui.app.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kg.geeks.compose.ui.data.repository.LocationRepository
import kotlinx.coroutines.launch

class LocationViewModel(
    private val locationRepository: LocationRepository
) : ViewModel() {

    fun fetchAllLocations() {
        viewModelScope.launch {
            val locations = locationRepository.fetchAllLocations()
            Log.e("LocationViewModel", "Fetched Locations: $locations")
        }
    }
}