package org.mathieu.sandbox.domain.repositories

import org.mathieu.sandbox.domain.models.Episode

/**
 * Data access layer interface for the [Episode] entity.
 */
interface IEpisodeRepository {

    /**
     * Try to retrieve an episode, using its id. If there is no episode found, then it returns null.
     *
     * @param id The id of the episode that we are looking for
     * @return It returns either an [Episode] or null if not found.
     */
    fun getEpisodeByIdOrNull(id: Int): Episode?

    /**
     * Retrieve all the episodes.
     *
     * @return A list of [Episode].
     */
    fun getEpisodes(): List<Episode>
}