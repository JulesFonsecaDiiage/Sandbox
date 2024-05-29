package org.mathieu.sandbox.domain.models

/**
 * This class represents a character in a TV show.
 *
 * @property id The id of the character
 * @property firstName The first name of the character
 * @property lastName The last name of the character
 * @property age The age of the character
 * @property episodes The list of episodes in which the character appears
 */
data class Character(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val age: Int,
    val episodes: List<Episode>
)