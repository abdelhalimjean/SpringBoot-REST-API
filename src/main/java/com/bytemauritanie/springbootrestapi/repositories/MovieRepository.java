package com.bytemauritanie.springbootrestapi.repositories;

import com.bytemauritanie.springbootrestapi.models.Movie;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// This annotation is used to mark a class as a repository bean.
// Repository beans are used to interact with a database.
public interface MovieRepository extends JpaRepository<Movie, Integer> {

  List<Movie> findByTitleContainingIgnoreCase(String title);
}
