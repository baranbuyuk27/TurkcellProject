package com.turkcell.spotifyproject.business.dto.PlaylistDto;

import com.turkcell.spotifyproject.entities.Music;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlaylistForListingDto {

    private int playlistId;
    private String playlistName;
    private LocalDate createdDate;
    private List<Music> musics;
}