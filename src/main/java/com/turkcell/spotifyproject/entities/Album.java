package com.turkcell.spotifyproject.entities;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "albums")
public class Album {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private UUID id;

  private String name;
  private LocalDate releaseDate;
  private long numberOfLikes;

  @ManyToOne
  @JoinColumn(name = "artist id")
  private Artist artist;

  @OneToMany(mappedBy = "album")
  private List<Music> musics;
}