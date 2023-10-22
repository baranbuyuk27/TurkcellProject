package com.turkcell.spotifyproject.business.concretes;

import com.turkcell.spotifyproject.business.abstracts.MusicService;
import com.turkcell.spotifyproject.business.dto.music.MusicForAddDto;
import com.turkcell.spotifyproject.business.dto.music.MusicForGetByIdDto;
import com.turkcell.spotifyproject.business.dto.music.MusicForListingDto;
import com.turkcell.spotifyproject.business.dto.music.MusicForUpdateDto;
import com.turkcell.spotifyproject.entities.Music;
import com.turkcell.spotifyproject.repositories.MusicRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MusicServiceImpl implements MusicService {

  private final MusicRepository musicRepository;

  @Override
  public void add(MusicForAddDto musicForAddDto) {
    Music music =
        Music.builder()
            .name(musicForAddDto.getName())
            .link(musicForAddDto.getLink())
            .duration(musicForAddDto.getDuration())
            .build();
    musicRepository.save(music);
  }

  @Override
  public void delete(Long id) {
    musicRepository.deleteById(id);
  }

  @Override
  public void update(MusicForUpdateDto musicForUpdateDto) {
    Music musicToUpdate = returnMusicByIdIfExist(musicForUpdateDto.getId());
    musicToUpdate.setName(musicToUpdate.getName());
    musicToUpdate.setLink(musicForUpdateDto.getLink());
    musicToUpdate.setPhoto(musicForUpdateDto.getPhoto());
    musicRepository.save(musicToUpdate);
  }

  @Override
  public List<MusicForListingDto> getAll() {

    return musicRepository.getForListing();
  }

  @Override
  public MusicForGetByIdDto getById(Long id) {
    return musicRepository.getForById(id);
  }

  private Music returnMusicByIdIfExist(Long id) {
    Music music = musicRepository.findById(id).orElse(null);
    if (music == null) throw new NullPointerException();
    return music;
  }
}
