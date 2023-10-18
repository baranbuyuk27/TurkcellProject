package com.turkcell.spotifyproject.controllers;

import com.turkcell.spotifyproject.business.abstracts.PlaylistService;
import com.turkcell.spotifyproject.business.dto.PlaylistDto.PlaylistForListingDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/playlist")
public class PlaylistController {

    private PlaylistService playlistService;

    @GetMapping
    List<PlaylistForListingDto> getPlaylist(){
        List<PlaylistForListingDto> playlistInDb = playlistService.getAll();
            return playlistInDb;
    }
}
