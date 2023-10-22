package com.turkcell.spotifyproject.business.dto.music;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MusicForGetByIdDto {
  private String name;
  private Date createdDate;
  private String link;
  private int numberOfLikes;
  private String photo;
  private float duration;
}
