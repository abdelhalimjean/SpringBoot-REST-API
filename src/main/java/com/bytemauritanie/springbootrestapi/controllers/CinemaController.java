package com.bytemauritanie.springbootrestapi.controllers;

import com.bytemauritanie.springbootrestapi.models.Cinema;
import com.bytemauritanie.springbootrestapi.services.CinemaService;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/cinema")
public class CinemaController {

  // dependency injection : basically being able to use CinemaService here
  @Autowired private CinemaService cinemaService;

  @GetMapping("/all")
  public ResponseEntity<List<Cinema>> listAllCinemas() {
    List<Cinema> cinemas = cinemaService.listAllCinemas();
    return new ResponseEntity<>(cinemas, HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Cinema> getById(@PathVariable int id) {
    try {
      Cinema cinema = cinemaService.getById(id);
      return new ResponseEntity<>(cinema, HttpStatus.OK);
    } catch (EntityNotFoundException ex) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping()
  public ResponseEntity<Cinema> addCinema(@RequestBody Cinema cinema) {
    Cinema createdCinema = cinemaService.addCinema(cinema);
    return new ResponseEntity<>(createdCinema, HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Cinema> updateCinema(@PathVariable int id, @RequestBody Cinema cinema) {
    try {
      Cinema updateCinema = cinemaService.updateCinema(id, cinema);
      return new ResponseEntity<>(updateCinema, HttpStatus.ACCEPTED);
    } catch (EntityNotFoundException ex) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Object> deleteCinema(@PathVariable int id) {
    cinemaService.deleteCinema(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
