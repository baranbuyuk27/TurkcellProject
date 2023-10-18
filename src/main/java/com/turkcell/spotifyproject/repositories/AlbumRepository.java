package com.turkcell.spotifyproject.repositories;

import com.turkcell.spotifyproject.entities.Album;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface AlbumRepository extends JpaRepository<Album, UUID> {
    List<Album> findAllByNameContainingIgnoreCase(String name);
}