package com.turkcell.spotifyproject.business.dto.music;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class MusicForUpdateDto {
  @NotNull(message = "Id degeri bos birakilamaz.")
  private Long id;

  @NotBlank(message = "Sarki ismi bos birakilamaz.")
  @Size(min = 3, max = 40, message = "Sarki ismi 3-40 hane arasinda olmalidir.")
  private String name;

  private String link;

  @NotNull(message = "Sure bos birakilamaz")
  @Positive(message = "Sure pozitif olmalidir.")
  private String photo;
}
