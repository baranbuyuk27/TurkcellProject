package com.turkcell.spotifyproject.controllers;

import com.turkcell.spotifyproject.business.abstracts.AlbumService;
import com.turkcell.spotifyproject.business.dto.CreateAlbumRequest;
import com.turkcell.spotifyproject.business.dto.CreateAlbumResponse;
import com.turkcell.spotifyproject.business.dto.GetAlbumResponse;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/albums")
public class AlbumController {
  private final AlbumService service;

  @GetMapping
  public List<GetAlbumResponse> getAll() {
    return service.getAll();
  }

  @GetMapping("/{id}")
  public GetAlbumResponse getById(@PathVariable UUID id) {
    return service.getById(id);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public CreateAlbumResponse createAlbum(@RequestBody CreateAlbumRequest albumRequest) {
    return service.createAlbum(albumRequest);
  }

  @DeleteMapping
  @ResponseStatus(HttpStatus.NO_CONTENT)
  void delete(UUID id) {
    service.delete(id);
  }
}