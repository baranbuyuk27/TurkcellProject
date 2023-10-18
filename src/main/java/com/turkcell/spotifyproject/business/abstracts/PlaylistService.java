package com.turkcell.spotifyproject.business.abstracts;

import com.turkcell.spotifyproject.business.dto.PlaylistDto.PlaylistForAddDto;
import com.turkcell.spotifyproject.business.dto.PlaylistDto.PlaylistForListingDto;
import com.turkcell.spotifyproject.business.dto.PlaylistDto.PlaylistForUpdateDto;

import java.util.List;

public interface PlaylistService {
    void addPlaylist(PlaylistForAddDto  request);
    List<PlaylistForListingDto> getAll();

    void updatePlaylist(int id, PlaylistForUpdateDto playlist);

    void delete(int id);

}
