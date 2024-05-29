package org.mathieu.sandbox.ui.screens.characterdetails

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import org.mathieu.sandbox.ui.components.episode.EpisodeCard

@Composable
fun CharacterDetailsScreen(
    navController: NavController,
    characterId: Int
) {
    val viewModel: CharacterDetailsViewModel = viewModel()
    val state: CharacterDetailsState by viewModel.state.collectAsState()

    // Initialize the ViewModel.
    LaunchedEffect(key1 = 0) {
        viewModel.initialize(id = characterId)
    }

    // Collect events emitted by the ViewModel.
    LaunchedEffect(viewModel.events) {
        viewModel.events
            .onEach { event ->

                when(event) {
                    is CharacterDetailsEvent.NavigateToDetails -> navController.navigate(
                        route = "episodes/${event.id}"
                    )

                    null -> { }
                }

            }.collect()
    }

    Content(
        state = state,
        clickedOnCard = {
            viewModel.navigateToDetails(it)
        }
    )
}


@Composable
private fun Content(
    state: CharacterDetailsState,
    clickedOnCard: (Int) -> Unit = { }
) = Column {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
    ) {
        Text(text = state.firstName)
        Text(text = state.lastName)
    }

        // Display the list of episodes
        state.episodes.forEach {
             EpisodeCard(
                date = it.date,
                name = it.name,
                onClick = { clickedOnCard(it.id) }
             )
        }
    }

@Preview
@Composable
private fun Preview() {
    Content(
        state = CharacterDetailsState()
    )
}