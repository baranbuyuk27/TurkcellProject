package com.turkcell.spotifyproject.entities;

import jakarta.persistence.*;
import java.util.Date;
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

  @Column(name = "pathOfPhoto")
  private String photo;

  @Column(name = "duration")
  private float duration;

  @Column(name = "album_id") // all the songs may not belong an album
  private int albumId;

  @ManyToOne private Artist artist;
}