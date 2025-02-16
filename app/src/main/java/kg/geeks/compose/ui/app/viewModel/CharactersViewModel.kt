package kg.geeks.compose.ui.app.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kg.geeks.compose.ui.data.repository.CharacterRepository
import kotlinx.coroutines.launch

class CharactersViewModel(
    private val characterRepository: CharacterRepository
): ViewModel() {


    fun fetchAllCharacters() {
        viewModelScope.launch {
            characterRepository.fetchAllCharacters()
            Log.e("CharactersViewModel", "fetchAllCharacters: $characterRepository")
        }
    }
}