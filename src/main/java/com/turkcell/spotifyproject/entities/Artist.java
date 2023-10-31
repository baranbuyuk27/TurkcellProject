package com.turkcell.spotifyproject.entities;

import jakarta.persistence.*;
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
@Table(name = "artists")
@DiscriminatorValue("Artist")
public class Artist extends User {

  private String name;

  @OneToMany(mappedBy = "artist")
  private List<Music> musics;

  @OneToMany(mappedBy = "artist")
  private List<Album> albums;
}