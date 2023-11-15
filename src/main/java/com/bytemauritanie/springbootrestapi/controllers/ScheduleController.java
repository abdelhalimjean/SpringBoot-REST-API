package com.bytemauritanie.springbootrestapi.controllers;

import com.bytemauritanie.springbootrestapi.dto.ScheduleRequestDTO;
import com.bytemauritanie.springbootrestapi.models.Schedule;
import com.bytemauritanie.springbootrestapi.services.ScheduleService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/schedule")
public class ScheduleController {

  // dependency injection : basically being able to use CinemaService here
  @Autowired private ScheduleService scheduleService;

  @GetMapping("/search")
  public ResponseEntity<List<Schedule>> search(@RequestParam String movie) {
    List<Schedule> scheduleList = scheduleService.search(movie);
    return new ResponseEntity<>(scheduleList, HttpStatus.OK);
  }

  @GetMapping("/{cinemaId}")
  public ResponseEntity<List<Schedule>> getScheduleByCinemaAndDate(
      @PathVariable int cinemaId, @RequestParam(required = false) LocalDate date) {
    List<Schedule> todaySchedule = scheduleService.getScheduleByCinemaAndDate(cinemaId, date);
    return new ResponseEntity<>(todaySchedule, HttpStatus.OK);
  }

  @PostMapping()
  public ResponseEntity<Schedule> addSchedule(@RequestBody ScheduleRequestDTO scheduleRequestDTO) {
    Schedule createdSchedule = scheduleService.addSchedule(scheduleRequestDTO);
    return new ResponseEntity<>(createdSchedule, HttpStatus.CREATED);
  }
}
