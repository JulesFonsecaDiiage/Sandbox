package org.mathieu.sandbox.ui.screens.episodeDetails

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import org.mathieu.sandbox.ui.components.episode.EpisodeCard

@Composable
fun EpisodeDetailsScreen(
    navController: NavController,
    episodeId: Int
) {
    val viewModel: EpisodeDetailsViewModel = viewModel()
    val state: EpisodeDetailsState by viewModel.state.collectAsState()

    LaunchedEffect(key1 = 0) {
        viewModel.initialize(id = episodeId)
    }

    Content(
        state = state
    )
}

@Composable
private fun Content(
    state: EpisodeDetailsState
) {
    Column {
        // Display the episode details
        EpisodeCard(
            date = state.date,
            name = state.name
        )

    }
}

@Preview
@Composable
fun Preview() {
    Content(state = EpisodeDetailsState())
}