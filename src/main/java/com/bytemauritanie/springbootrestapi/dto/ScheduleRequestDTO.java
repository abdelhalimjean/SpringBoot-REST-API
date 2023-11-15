package com.bytemauritanie.springbootrestapi.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class ScheduleRequestDTO {

  @NotNull(message = "Cinema is required")
  private Integer cinemaId;

  @NotNull(message = "Movie is required")
  private Integer movieId;

  @NotNull(message = "Time is required")
  @Future(message = "The scheduled time should be in the future")
  private LocalDateTime time;

  @NotNull(message = "Ticket price is required")
  @Min(value = 0, message = "The minimum value for the ticket price is 0")
  @Max(value = 100, message = "The maximum value for the ticket price is 100")
  private Integer ticketPrice;

  public Integer getCinemaId() {
    return cinemaId;
  }

  public void setCinemaId(Integer cinemaId) {
    this.cinemaId = cinemaId;
  }

  public Integer getMovieId() {
    return movieId;
  }

  public void setMovieId(Integer movieId) {
    this.movieId = movieId;
  }

  public LocalDateTime getTime() {
    return time;
  }

  public void setTime(LocalDateTime time) {
    this.time = time;
  }

  public Integer getTicketPrice() {
    return ticketPrice;
  }

  public void setTicketPrice(Integer ticketPrice) {
    this.ticketPrice = ticketPrice;
  }
}
