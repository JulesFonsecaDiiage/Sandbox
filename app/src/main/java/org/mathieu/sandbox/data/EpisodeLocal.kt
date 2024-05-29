package org.mathieu.sandbox.data

import org.mathieu.sandbox.domain.models.Episode

/**
 * This object represents the local data source for the episodes.
 */
object EpisodeLocal {
    var episodesJohnSnow: MutableList<Episode> = mutableListOf(
        Episode(
            id = 1,
            name = "Winter is coming",
            date = "2024-05-29"
        ),
        Episode(
            id = 2,
            name = "The Red Wedding",
            date = "2024-05-29"
        ),
        Episode(
            id = 3,
            name = "Lord Snow",
            date = "2024-05-29"
        )
    )

    var episodesJackSparrow: MutableList<Episode> = mutableListOf(
        Episode(
            id = 4,
            name = "Pirates of the Caribbean",
            date = "2024-05-29"
        ),
        Episode(
            id = 5,
            name = "Pirates of the Caribbean 2",
            date = "2024-05-29"
        ),
        Episode(
            id = 6,
            name = "Pirates of the Caribbean 3",
            date = "2024-05-29"
        )
    )

    var episodesAnakinSkywalker: MutableList<Episode> = mutableListOf(
        Episode(
            id = 7,
            name = "Star Wars",
            date = "2024-05-29"
        ),
        Episode(
            id = 8,
            name = "Star Wars 2",
            date = "2024-05-29"
        ),
        Episode(
            id = 9,
            name = "Star Wars 3",
            date = "2024-05-29"
        )
    )

    var episodes: List<Episode> = episodesJohnSnow + episodesJackSparrow + episodesAnakinSkywalker
}