package com.bytemauritanie.springbootrestapi.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table
public class Movie {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Integer id;

  @Column(nullable = false)
  private String title;

  @Column(nullable = false)
  private LocalDate releaseDate;

  @Column(nullable = false)
  private Long revenue;

  @Column(nullable = false)
  private Long budget;

  private String youtubeLink;
  private String imdbLink;
  private String wikipediaLink;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public LocalDate getReleaseDate() {
    return releaseDate;
  }

  public void setReleaseDate(LocalDate releaseDate) {
    this.releaseDate = releaseDate;
  }

  public Long getRevenue() {
    return revenue;
  }

  public void setRevenue(Long revenue) {
    this.revenue = revenue;
  }

  public Long getBudget() {
    return budget;
  }

  public void setBudget(Long budget) {
    this.budget = budget;
  }

  public String getYoutubeLink() {
    return youtubeLink;
  }

  public void setYoutubeLink(String youtubeLink) {
    this.youtubeLink = youtubeLink;
  }

  public String getImdbLink() {
    return imdbLink;
  }

  public void setImdbLink(String imdbLink) {
    this.imdbLink = imdbLink;
  }

  public String getWikipediaLink() {
    return wikipediaLink;
  }

  public void setWikipediaLink(String wikipediaLink) {
    this.wikipediaLink = wikipediaLink;
  }
}
