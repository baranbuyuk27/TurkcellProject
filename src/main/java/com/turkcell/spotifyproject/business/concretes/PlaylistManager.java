package com.turkcell.spotifyproject.business.concretes;

import com.turkcell.spotifyproject.business.abstracts.PlaylistService;
import com.turkcell.spotifyproject.business.dto.PlaylistDto.PlaylistForAddDto;
import com.turkcell.spotifyproject.business.dto.PlaylistDto.PlaylistForListingDto;
import com.turkcell.spotifyproject.business.dto.PlaylistDto.PlaylistForUpdateDto;
import com.turkcell.spotifyproject.repositories.PlaylistRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlaylistManager implements PlaylistService {

  private final PlaylistRepository playlistRepository;

  private ModelMapper modelMapper;

  @Override
  public void addPlaylist(PlaylistForAddDto request) {}

  public List<PlaylistForListingDto> getAll() {
    // return playlistRepository.getForListing();
    return null;
  }

  @Override
  public void updatePlaylist(int id, PlaylistForUpdateDto playlist) {}

  @Override
  public void delete(int id) {}
}