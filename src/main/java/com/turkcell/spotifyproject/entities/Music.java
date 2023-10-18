package com.turkcell.spotifyproject.entities;

import jakarta.persistence.*;

import java.awt.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "musics")
public class Music {
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(name = "name")
  private String name;

  @Column(name = "created_date")
  private Date createdDate;

  @Column(name = "link")
  private String link;

  @Column(name = "likes")
  private int numberOfLikes;

  @Column(name = "photosOfPath")
  private String photo;

  @Column(name = "duration")
  private float duration;

  /*@ManyToMany(cascade = {CascadeType.ALL})
  @JoinTable(
      name = "musics_artists",
      joinColumns = {@JoinColumn(name = "music_id")},
      inverseJoinColumns = {@JoinColumn(name = "artist_id")})
  private List<Artist> artists;*/
}