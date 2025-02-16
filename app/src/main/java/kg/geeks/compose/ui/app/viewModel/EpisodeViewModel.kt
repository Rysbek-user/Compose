package kg.geeks.compose.ui.app.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kg.geeks.compose.ui.data.repository.EpisodeRepository
import kotlinx.coroutines.launch

class EpisodeViewModel(
    private val episodeRepository: EpisodeRepository
) : ViewModel() {

    fun fetchAllEpisodes() {
        viewModelScope.launch {
            val episodes = episodeRepository.fetchAllEpisodes()
            Log.e("EpisodeViewModel", "Fetched Episodes: $episodes")
        }
    }
}