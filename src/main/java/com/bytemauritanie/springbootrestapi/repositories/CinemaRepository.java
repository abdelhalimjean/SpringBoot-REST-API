package com.bytemauritanie.springbootrestapi.repositories;

import com.bytemauritanie.springbootrestapi.models.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema, Integer> {}
