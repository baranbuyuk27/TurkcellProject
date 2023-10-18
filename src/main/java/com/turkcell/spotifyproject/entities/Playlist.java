package com.turkcell.spotifyproject.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "playlists")
public class Playlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "playlist_name")
    private String playlistName;

    @Column(name = "created_date")
    private LocalDate createdDate;

    @OneToMany(mappedBy = "playlist")
    private List<Music> musics;


}