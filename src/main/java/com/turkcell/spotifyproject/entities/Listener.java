package com.turkcell.spotifyproject.entities;

import jakarta.persistence.*;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
@DiscriminatorValue("Listener")
public class Listener extends User {

  @OneToMany(mappedBy = "listener")
  private List<Playlist> playlists;
}