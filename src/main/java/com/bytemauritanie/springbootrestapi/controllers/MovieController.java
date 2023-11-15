package com.bytemauritanie.springbootrestapi.controllers;

import com.bytemauritanie.springbootrestapi.models.Movie;
import com.bytemauritanie.springbootrestapi.services.MovieService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
// This annotation is used to define a class as a RESTful controller.
// It is often used in combination with @RequestMapping to handle HTTP requests.
@RequestMapping("/api/v1/movie")
// This annotation is used to map HTTP requests to specific handler methods in the controller.
// It can be applied at the class level and/or method level.
public class MovieController {

  // dependency injection : basically being able to use MovieService here
  @Autowired private MovieService movieService;

  //  @RequestMapping(value = "/all", method = RequestMethod.GET)
  @GetMapping("/all")
  public ResponseEntity<List<Movie>> listAllMovies() {
    List<Movie> movies = movieService.listAllMovies();
    return new ResponseEntity<>(movies, HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Movie> getById(@PathVariable int id) {
    try {
      Movie movie = movieService.getById(id);
      return new ResponseEntity<>(movie, HttpStatus.OK);
    } catch (EntityNotFoundException ex) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping()
  public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
    Movie createdMovie = movieService.addMovie(movie);
    return new ResponseEntity<>(createdMovie, HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Movie> updateMovie(@PathVariable int id, @RequestBody Movie movie) {
    try {
      Movie updateMovie = movieService.updateMovie(id, movie);
      return new ResponseEntity<>(updateMovie, HttpStatus.ACCEPTED);
    } catch (EntityNotFoundException ex) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Object> deleteMovie(@PathVariable int id) {
    movieService.deleteMovie(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @GetMapping("/search")
  public ResponseEntity<List<Movie>> searchMovies(@RequestParam String title) {
    List<Movie> movies = movieService.searchMovies(title);
    return new ResponseEntity<>(movies, HttpStatus.OK);
  }
}
