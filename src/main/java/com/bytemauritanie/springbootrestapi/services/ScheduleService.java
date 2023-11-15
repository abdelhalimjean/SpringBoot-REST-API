package com.bytemauritanie.springbootrestapi.services;

import com.bytemauritanie.springbootrestapi.dto.ScheduleRequestDTO;
import com.bytemauritanie.springbootrestapi.models.Cinema;
import com.bytemauritanie.springbootrestapi.models.Movie;
import com.bytemauritanie.springbootrestapi.models.Schedule;
import com.bytemauritanie.springbootrestapi.repositories.ScheduleRepository;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {

  // dependency injection : basically being able to use ScheduleRepository here
  @Autowired private ScheduleRepository scheduleRepository;
  // dependency injection : basically being able to use MovieService here
  @Autowired private MovieService movieService;
  // dependency injection : basically being able to use CinemaService here
  @Autowired private CinemaService cinemaService;

  public List<Schedule> search(String movie) {
    List<Schedule> scheduleList = scheduleRepository.searchSchedules(movie, LocalDateTime.now());
    return scheduleList;
  }

  public List<Schedule> getScheduleByCinemaAndDate(int cinemaId, LocalDate date) {

    LocalDate searchDate;
    if (date != null) {
      searchDate = date;
    } else {
      searchDate = LocalDate.now();
    }
    List<Schedule> allScheduleForCinema =
        scheduleRepository.findByCinemaIdAndTimeBetween(
            cinemaId, searchDate.atTime(LocalTime.MIN), searchDate.atTime(LocalTime.MAX));

    return allScheduleForCinema;
  }

  public Schedule addSchedule(ScheduleRequestDTO scheduleRequestDTO) {
    Cinema cinema = cinemaService.getById(scheduleRequestDTO.getCinemaId());
    Movie movie = movieService.getById(scheduleRequestDTO.getMovieId());
    Schedule schedule = new Schedule();
    schedule.setCinema(cinema);
    schedule.setMovie(movie);
    schedule.setTime(scheduleRequestDTO.getTime());
    schedule.setTicketPrice(scheduleRequestDTO.getTicketPrice());
    Schedule savedSchedule = scheduleRepository.save(schedule);
    return savedSchedule;
  }
}
