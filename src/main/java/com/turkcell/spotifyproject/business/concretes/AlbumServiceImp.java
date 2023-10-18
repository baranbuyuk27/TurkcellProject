package com.turkcell.spotifyproject.business.concretes;

import com.turkcell.spotifyproject.business.abstracts.AlbumService;
import com.turkcell.spotifyproject.business.dto.CreateAlbumRequest;
import com.turkcell.spotifyproject.business.dto.CreateAlbumResponse;
import com.turkcell.spotifyproject.business.dto.GetAlbumResponse;
import com.turkcell.spotifyproject.entities.Album;
import com.turkcell.spotifyproject.repositories.AlbumRepository;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AlbumServiceImp implements AlbumService {
  private final AlbumRepository repository;
  private ModelMapper mapper;

  @Override
  public GetAlbumResponse getById(UUID id) {
    Album album = repository.findById(id).orElseThrow();
    return mapper.map(album, GetAlbumResponse.class);
  }

  @Override
  public List<GetAlbumResponse> getAll() {
    return repository.findAll().stream()
        .map(album -> mapper.map(album, GetAlbumResponse.class))
        .toList();
  }

  @Override
  public CreateAlbumResponse createAlbum(CreateAlbumRequest albumRequest) {
    Album album = mapper.map(albumRequest, Album.class);
    album.setReleaseDate(LocalDate.from(LocalDateTime.now()));
    album.setNumberOfLikes(0);
    // set artist here
    Album newAlbum = repository.save(album);
    return mapper.map(newAlbum, CreateAlbumResponse.class);
  }

  @Override
  public void delete(UUID id) {
    repository.deleteById(id);
  }
}