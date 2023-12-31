package com.turkcell.spotifyproject.repositories;

import com.turkcell.spotifyproject.entities.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaylistRepository extends JpaRepository<Playlist, Integer> {

  /**
   * @Query( value = "SELECT new " +
   * "package.com.turkcell.spotifyproject.business.dto.PlaylistDto.PlaylistForListingDto" +
   * "(p.playlistId, p.playlistName) FROM Playlist p") List<PlaylistForListingDto> getForListing();
   */
}