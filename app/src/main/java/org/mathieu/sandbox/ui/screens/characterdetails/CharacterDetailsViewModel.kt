package org.mathieu.sandbox.ui.screens.characterdetails

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import org.mathieu.sandbox.data.CharacterRepositoryImpl
import org.mathieu.sandbox.domain.models.Episode

sealed interface CharacterDetailsEvent {
    data class NavigateToDetails(val id: Int) : CharacterDetailsEvent
}

class CharacterDetailsViewModel(application: Application) : AndroidViewModel(application) {
    private val _state: MutableStateFlow<CharacterDetailsState> = MutableStateFlow(CharacterDetailsState())
    private val _events = Channel<CharacterDetailsEvent>(Channel.BUFFERED)

    val state: StateFlow<CharacterDetailsState>
        get() = _state
    val events: Flow<CharacterDetailsEvent>
        get() = _events.receiveAsFlow()

    fun initialize(id: Int) {
        val character = CharacterRepositoryImpl.getCharacterByIdOrNull(id)!!

        _state.value = CharacterDetailsState(
            firstName = character.firstName,
            lastName = character.lastName,
            episodes = character.episodes
        )
    }

    fun navigateToDetails(id: Int) {
        viewModelScope.launch {
            _events.send(CharacterDetailsEvent.NavigateToDetails(id = id))
        }
    }
}

/**
 * State for the [CharacterDetailsViewModel]
 *
 * @param firstName The first name of the character
 * @param lastName The last name of the character
 * @param episodes The list of episodes in which the character appears
 */
data class CharacterDetailsState(
    val firstName: String = "",
    val lastName: String = "",
    val episodes: List<Episode> = emptyList()
)