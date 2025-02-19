package kg.geeks.compose.ui.viewModule

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kg.geeks.compose.ui.data.dto.CharacterResponse
import kg.geeks.compose.ui.data.repository.CharacterRepasitory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class CharacterViewModule(private val characterRepasitory: CharacterRepasitory) : ViewModel() {

    private val _characters = MutableStateFlow<List<CharacterResponse>>(emptyList())
    val characters = _characters

    private val _characterDetails = MutableStateFlow<CharacterResponse?>(null)
    val characterDetails = _characterDetails

    init {
        fetchAllCharacters()
    }

    fun fetchAllCharacters() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = characterRepasitory.fetchCharacters()
                if (response.isSuccessful) {
                    _characters.value = response.body()?.result ?: emptyList()
                } else {
                    Log.e("CharacterViewModel", "Ошибка: ${response.code()} - ${response.message()}")
                }
            } catch (e: Exception) {
                Log.e("CharacterViewModel", "Ошибка при загрузке данных: ${e.message}", e)
            }
        }
    }

    fun getCharacterDetails(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = characterRepasitory.getCharacterDetails(id)
                if (response.isSuccessful) {
                    _characterDetails.value = response.body()
                } else {
                    Log.e("CharacterViewModel", "Ошибка: ${response.code()} - ${response.message()}")
                }
            } catch (e: Exception) {
                Log.e("CharacterViewModel", "Ошибка при загрузке данных: ${e.message}", e)
            }
        }
    }
}