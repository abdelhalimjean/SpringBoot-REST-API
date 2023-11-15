package com.bytemauritanie.springbootrestapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// This annotation is used to mark the main class of a Spring Boot application.
// It combines three annotations: @Configuration, @EnableAutoConfiguration, and @ComponentScan.
public class SpringBootRestApiApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringBootRestApiApplication.class, args);
  }
}
