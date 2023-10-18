package com.turkcell.spotifyproject.business.dto;

import com.turkcell.spotifyproject.entities.Music;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateAlbumResponse {
  private UUID id;
  private String name;
  private LocalDate releaseDate;
  private long numberOfLikes;
  private String artistName;
  private List<Music> musics;
}