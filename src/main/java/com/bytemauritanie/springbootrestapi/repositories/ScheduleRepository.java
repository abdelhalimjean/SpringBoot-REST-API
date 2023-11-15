package com.bytemauritanie.springbootrestapi.repositories;

import com.bytemauritanie.springbootrestapi.models.Schedule;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {
  List<Schedule> findByMovieTitleContainingIgnoreCaseAndTimeIsAfter(
      String movie, LocalDateTime startDate);

  @Query(
      "SELECT s FROM Schedule s "
          + "WHERE LOWER(s.movie.title) LIKE LOWER(CONCAT('%', :movieTitle, '%')) "
          + "AND  s.time > :now ")
  List<Schedule> searchSchedules(
      @Param("movieTitle") String movieTitle, @Param("now") LocalDateTime now);

  List<Schedule> findByCinemaIdAndTimeBetween(
      int cinemaId, LocalDateTime startOfDay, LocalDateTime endOfDay);
}
