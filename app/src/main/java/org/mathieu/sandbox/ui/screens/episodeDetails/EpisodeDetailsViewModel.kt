package org.mathieu.sandbox.ui.screens.episodeDetails

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import org.mathieu.sandbox.data.EpisodeRepositoryImpl

class EpisodeDetailsViewModel(application: Application) : AndroidViewModel(application) {
    private val _state: MutableStateFlow<EpisodeDetailsState> = MutableStateFlow(EpisodeDetailsState())

    val state: StateFlow<EpisodeDetailsState>
        get() = _state

    fun initialize(id: Int) {
        val episode = EpisodeRepositoryImpl.getEpisodeByIdOrNull(id)!!

        _state.value = EpisodeDetailsState(
            date = episode.date,
            name = episode.name
        )

    }
}

/**
 * State for the [EpisodeDetailsViewModel]
 *
 * @param date The date of the episode
 * @param name The name of the episode
 */
data class EpisodeDetailsState(
    val date: String = "",
    val name: String = ""
)