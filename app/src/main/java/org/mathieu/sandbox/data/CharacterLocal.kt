package org.mathieu.sandbox.data

import org.mathieu.sandbox.domain.models.Character

/**
 * This object represents the local data source for the characters.
 */
object CharacterLocal {
    var characters: MutableList<Character> = mutableListOf(
        Character(
            id = 1,
            firstName = "John",
            lastName = "Snow",
            age = 20,
            episodes = EpisodeLocal.episodesJohnSnow
        ),
        Character(
            id = 2,
            firstName = "Jack",
            lastName = "Sparrow",
            age = 21,
            episodes = EpisodeLocal.episodesJackSparrow
        ),
        Character(
            id = 3,
            firstName = "Anakin",
            lastName = "Skywalker",
            age = 22,
            episodes = EpisodeLocal.episodesAnakinSkywalker
        )
    )
}