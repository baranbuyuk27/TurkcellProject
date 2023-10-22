package com.turkcell.spotifyproject.business.dto.music;

import lombok.Data;

@Data
public class MusicForAddDto {
  private String name;
  private String link;
  private float duration;
}
