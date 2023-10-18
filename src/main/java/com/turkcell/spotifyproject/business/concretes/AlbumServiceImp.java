package com.turkcell.spotifyproject.business.concretes;

import com.turkcell.spotifyproject.business.abstracts.AlbumService;
import com.turkcell.spotifyproject.business.dto.CreateAlbumRequest;
import com.turkcell.spotifyproject.business.dto.CreateAlbumResponse;
import com.turkcell.spotifyproject.business.dto.GetAlbumResponse;
import com.turkcell.spotifyproject.entities.Album;
import com.turkcell.spotifyproject.repositories.AlbumRepository;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AlbumServiceImp implements AlbumService {
  private final AlbumRepository albumRepository;
  private ModelMapper mapper;

  @Override
  public GetAlbumResponse getById(UUID id) {
    Album album = albumRepository.findById(id).orElseThrow();
    return mapper.map(album, GetAlbumResponse.class);
  }

  @Override
  public List<GetAlbumResponse> getAll() {
    albumRepository.findAll();
  }

  @Override
  public CreateAlbumResponse createAlbum(CreateAlbumRequest albumRequest) {
    return null;
  }

  @Override
  public void delete(UUID id) {}
}