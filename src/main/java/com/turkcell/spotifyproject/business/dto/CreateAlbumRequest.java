package com.turkcell.spotifyproject.business.dto;

import com.turkcell.spotifyproject.entities.Artist;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateAlbumRequest {
  private String name;
  private Artist artist;
}