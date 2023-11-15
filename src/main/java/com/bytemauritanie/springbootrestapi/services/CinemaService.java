package com.bytemauritanie.springbootrestapi.services;

import com.bytemauritanie.springbootrestapi.models.Cinema;
import com.bytemauritanie.springbootrestapi.repositories.CinemaRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CinemaService {

  // dependency injection : basically being able to use CinemaRepository here
  @Autowired private CinemaRepository cinemaRepository;

  public Cinema addCinema(Cinema cinema) {
    return cinemaRepository.save(cinema);
  }

  public Cinema getById(int id) {
    Optional<Cinema> cinemaOptional = cinemaRepository.findById(id);
    if (cinemaOptional.isPresent()) {
      return cinemaOptional.get();
    } else {
      throw new EntityNotFoundException("no cinema found with the id " + id);
    }
  }

  public List<Cinema> listAllCinemas() {
    return cinemaRepository.findAll();
  }

  public Cinema updateCinema(int id, Cinema cinema) {
    if (!cinemaRepository.existsById(id)) {
      throw new EntityNotFoundException("no cinema found with the id " + id);
    }
    return cinemaRepository.save(cinema);
  }

  public void deleteCinema(int id) {
    cinemaRepository.deleteById(id);
  }
}
