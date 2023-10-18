package com.turkcell.spotifyproject.business.concretes;

import com.turkcell.spotifyproject.business.abstracts.PlaylistService;
import com.turkcell.spotifyproject.business.dto.PlaylistDto.PlaylistForAddDto;
import com.turkcell.spotifyproject.business.dto.PlaylistDto.PlaylistForListingDto;
import com.turkcell.spotifyproject.business.dto.PlaylistDto.PlaylistForUpdateDto;
import com.turkcell.spotifyproject.repositories.PlaylistRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PlaylistManager implements PlaylistService {

    @Autowired
     private PlaylistRepository playlistRepository;

    private ModelMapper modelMapper;


    @Override
    public void addPlaylist(PlaylistForAddDto request) {

    }

    @Override
    public List<PlaylistForListingDto> getAll() {
        return playlistRepository.getForListing();
    }

    @Override
    public void updatePlaylist(int id, PlaylistForUpdateDto playlist) {

    }

    @Override
    public void delete(int id) {

    }
}
