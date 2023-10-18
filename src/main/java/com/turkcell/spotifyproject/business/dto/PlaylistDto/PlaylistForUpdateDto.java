package com.turkcell.spotifyproject.business.dto.PlaylistDto;

import com.turkcell.spotifyproject.entities.Music;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlaylistForUpdateDto {

    private int id;
    private String playlistName;
    private List<Music> musics;

}