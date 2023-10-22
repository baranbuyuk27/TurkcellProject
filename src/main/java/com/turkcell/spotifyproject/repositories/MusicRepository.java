package com.turkcell.spotifyproject.repositories;

import com.turkcell.spotifyproject.business.dto.music.MusicForGetByIdDto;
import com.turkcell.spotifyproject.business.dto.music.MusicForListingDto;
import com.turkcell.spotifyproject.entities.Music;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MusicRepository extends JpaRepository<Music, Long> {

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
}
