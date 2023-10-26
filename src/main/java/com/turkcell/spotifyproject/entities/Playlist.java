package com.turkcell.spotifyproject.entities;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true) // unidirectional
  private List<Music> musics;

  @ManyToOne private Listener listener;
}