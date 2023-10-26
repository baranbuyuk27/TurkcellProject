package com.turkcell.spotifyproject.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class Listener extends User {
    private int id;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Playlist> playlists;
}
