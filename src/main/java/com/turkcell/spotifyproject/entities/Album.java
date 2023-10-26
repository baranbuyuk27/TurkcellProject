package com.turkcell.spotifyproject.entities;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;
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
  private int id;

  private String name;
  private LocalDate releaseDate;
  private long numberOfLikes;

  @ManyToOne private Artist artist;

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true) // unidirectional
  private List<Music> musics;
}