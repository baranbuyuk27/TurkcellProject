package com.turkcell.spotifyproject.controllers;

import com.turkcell.spotifyproject.business.abstracts.MusicService;
import com.turkcell.spotifyproject.business.dto.music.MusicForAddDto;
import com.turkcell.spotifyproject.business.dto.music.MusicForGetByIdDto;
import com.turkcell.spotifyproject.business.dto.music.MusicForListingDto;
import com.turkcell.spotifyproject.business.dto.music.MusicForUpdateDto;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("musics")
@RequiredArgsConstructor
public class MusicController {

  private final MusicService musicService;

  @GetMapping()
  public List<MusicForListingDto> getMusics() {
    return musicService.getAll();
  }

  @DeleteMapping("delete/{id}")
  public ResponseEntity delete(@PathVariable("id") Long id) {
    musicService.delete(id);
    return new ResponseEntity("Muzik silindi", HttpStatus.CREATED);
  }

  @PutMapping("update")
  public ResponseEntity update(@RequestBody @Valid MusicForUpdateDto request) {
    musicService.update(request);
    return new ResponseEntity("Muzik güncellendi", HttpStatus.CREATED);
  }

  @GetMapping("getById")
  public MusicForGetByIdDto getMusicById(@RequestParam("id") Long id) {
    return musicService.getById(id);
  }

  @PostMapping("add")
  public ResponseEntity add(@RequestBody @Valid MusicForAddDto request) {
    musicService.add(request);
    return new ResponseEntity("Muzik eklendi", HttpStatus.CREATED);
  }
}
