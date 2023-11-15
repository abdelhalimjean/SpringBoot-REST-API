package com.bytemauritanie.springbootrestapi.services;

import com.bytemauritanie.springbootrestapi.models.Movie;
import com.bytemauritanie.springbootrestapi.repositories.MovieRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
// This annotation is used to mark a class as a service bean.
// Service beans are typically used to contain business logic
public class MovieService {

  // dependency injection : basically being able to use MovieRepository here
  @Autowired private MovieRepository movieRepository;

  public Movie addMovie(Movie movie) {
    return movieRepository.save(movie);
  }

  public Movie getById(int id) {
    Optional<Movie> movieOptional = movieRepository.findById(id);
    if (movieOptional.isPresent()) {
      return movieOptional.get();
    } else {
      throw new EntityNotFoundException("no movie found with the id " + id);
    }
  }

  public List<Movie> listAllMovies() {
    return movieRepository.findAll();
  }

  public List<Movie> searchMovies(String title) {
    return movieRepository.findByTitleContainingIgnoreCase(title);
  }

  public Movie updateMovie(int id, Movie movie) {
    if (!movieRepository.existsById(id)) {
      throw new EntityNotFoundException("no movie found with the id " + id);
    }
    return movieRepository.save(movie);
  }

  public void deleteMovie(int id) {
    movieRepository.deleteById(id);
  }
}
