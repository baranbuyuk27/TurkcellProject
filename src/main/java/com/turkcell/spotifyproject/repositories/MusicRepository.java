package com.turkcell.spotifyproject.repositories;

import com.turkcell.spotifyproject.business.dto.music.MusicForGetByIdDto;
import com.turkcell.spotifyproject.business.dto.music.MusicForListingDto;
import com.turkcell.spotifyproject.entities.Music;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MusicRepository extends JpaRepository<Music, Long> {

  // Derived Query
  @Query(
      value =
          "Select new com.turkcell.spotifyproject.business.dto.music.MusicForGetByIdDto"
              + "(m.name,m.createdData,m.link,m.numberOfLikes,m.photo,m.duration) from Music m "
              + "Where m.id = :id")
  MusicForGetByIdDto getForById(Long id);

  @Query(
      value =
          "Select new com.turkcell.spotifyproject.business.dto.music.MusicForGetByIdDto"
              + "(m.name,m.createdData,m.link,m.numberOfLikes,m.photo,m.duration) from Music m ")
  List<MusicForListingDto> getForListing();

  // NativeQuery
  @Query(value = "SELECT * FROM musics  WHERE name LIKE %:musicName%", nativeQuery = true)
  List<MusicForListingDto> search(String musicName);

  // JPQL
  @Query(
      "SELECT new com.turkcell.spotifyproject.business.dto.MusicForListingDto"
          + "(m.name, m.createdDate, m.link, m.numberOfLikes, m.photo, m.duration) FROM Music m ORDER BY m.numberOfLikes DESC")
  List<MusicForListingDto> findByNumberOfLikesDesc();

  @Query(
      "SELECT new com.turkcell.spotifyproject.business.dto.MusicForListingDto"
          + "(m.name, m.createdDate, m.link, m.numberOfLikes, m.photo, m.duration) FROM Music m WHERE m.albumId = :albumId")
  List<MusicForListingDto> findByAlbumId(@Param("albumId") int albumId);

  // Artist'in user nesnesini extends ettigi icin Hata verebilir!!
  @Query(
      "SELECT new com.turkcell.spotifyproject.business.dto.MusicForListingDto"
          + "(m.name, m.createdDate, m.link, m.numberOfLikes, m.photo, m.duration) FROM Music m WHERE m.artist.id = :artistId")
  List<MusicForListingDto> findMusicsByArtistId(@Param("artistId") int artistId);
}
