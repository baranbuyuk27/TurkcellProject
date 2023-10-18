package com.turkcell.spotifyproject.business.abstracts;

import com.turkcell.spotifyproject.business.dto.CreateAlbumRequest;
import com.turkcell.spotifyproject.business.dto.CreateAlbumResponse;
import com.turkcell.spotifyproject.business.dto.GetAlbumResponse;
import java.util.List;
import java.util.UUID;

public interface AlbumService {
  List<GetAlbumResponse> getAll();

  GetAlbumResponse getById(UUID id);

  CreateAlbumResponse createAlbum(CreateAlbumRequest albumRequest);

  void delete(UUID id);
}