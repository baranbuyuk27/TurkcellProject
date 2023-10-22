package com.turkcell.spotifyproject.business.dto.music;

import lombok.Data;

@Data
public class MusicForUpdateDto {
  private Long id;
  private String name;
  private String link;
  private String photo;
}
