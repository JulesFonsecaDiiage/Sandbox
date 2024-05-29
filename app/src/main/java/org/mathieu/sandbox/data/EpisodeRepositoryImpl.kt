package org.mathieu.sandbox.data

import org.mathieu.sandbox.domain.models.Episode
import org.mathieu.sandbox.domain.repositories.IEpisodeRepository

/**
 * Implementation of the [IEpisodeRepository] interface.
 *
 * This implementation is a local implementation using a static list of episodes.
 */
object EpisodeRepositoryImpl: IEpisodeRepository {

    /**
     * Try to retrieve an episode, using its id. If there is no episode found, then it returns null.
     *
     * @param id The id of the episode that we are looking for
     * @return It returns either an [Episode] or null if not found.
     */
    override fun getEpisodeByIdOrNull(id: Int): Episode? {
        return EpisodeLocal.episodes.find { episode ->
            episode.id == id
        }
    }

    /**
     * Retrieve all the episodes
     *
     * @return A list of [Episode]
     */
    override fun getEpisodes() = EpisodeLocal.episodes
}