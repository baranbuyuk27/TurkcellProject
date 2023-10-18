package com.turkcell.spotifyproject.business.dto.PlaylistDto;

import com.turkcell.spotifyproject.entities.Music;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlaylistForAddDto {
    private String playlistName;
    private List<Music> musics;

}