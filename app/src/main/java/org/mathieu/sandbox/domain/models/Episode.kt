package org.mathieu.sandbox.domain.models


/**
 * This class represents an episode of a TV show.
 *
 * @property id The id of the episode
 * @property name The name of the episode
 * @property date The date of the episode
 */
data class Episode(
    val id: Int,
    val name: String,
    val date: String
)