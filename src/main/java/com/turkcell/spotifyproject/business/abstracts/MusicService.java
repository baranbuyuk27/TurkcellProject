package com.turkcell.spotifyproject.business.abstracts;

import com.turkcell.spotifyproject.business.dto.music.MusicForAddDto;
import com.turkcell.spotifyproject.business.dto.music.MusicForGetByIdDto;
import com.turkcell.spotifyproject.business.dto.music.MusicForListingDto;
import com.turkcell.spotifyproject.business.dto.music.MusicForUpdateDto;
import java.util.List;

public interface MusicService {
  void add(MusicForAddDto musicForAddDto);

  void delete(Long id);

  void update(MusicForUpdateDto musicForUpdateDto);

  List<MusicForListingDto> getAll();

  MusicForGetByIdDto getById(Long id);
}
