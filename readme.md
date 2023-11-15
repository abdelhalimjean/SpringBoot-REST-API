<a href="https://www.youtube.com/c/ByteMauritanie?sub_confirmation=1">
<img src="src/main/resources/img/byte-logo.png" alt="Byte logo" height="200">
<img src="src/main/resources/img/youtube.png" alt="Byte logo" height="200">
</a>

# Spring Boot Movie CRUD REST API with PostgreSQL

<img src="src/main/resources/img/springboot-logo.png" alt="Byte logo" height="150">
<img src="src/main/resources/img/postgresql-logo.png" alt="Byte logo" height="150">


This is a simple Spring Boot REST API for managing movie data. The application uses PostgreSQL as
the database

## Getting Started

These instructions will help you set up and run the project on your local machine.

### Prerequisites

- Java Development Kit (JDK) installed (version 17 or later)
- PostgreSQL installed and running
    - *you can pick another database, but you'll have to do the
      necessary changes in `pom.xml` and `application.properties`
- Your favorite IDE (preferably IntelliJ) installed and running

### Setup

1. Clone the repository:

   ```bash
   git clone https://github.com/abdelhalimjean/SpringBoot-REST-API.git
    ```
2. Open the project folder in your favorite IDE
3. Open `src/main/resources/application.properties` and update the PostgreSQL connection properties
   if needed.
4. Ensure that the PostgreSQL server is running, and create the database `MoviesDB` and a user and
   password as mentioned in
   the `application.properties` file.
5. After running `SpringBootRestApiApplication.java` the application will be accessible
   at http://localhost:8080/ (you
   will see a "Whitelabel Error Page" don't worry, that's what's supposed to happen, it means
   everything is working)
6. After running the application, the tables will be automatically created, only then can you run
   the data initialization scripts.

## Data Initialization

The project includes some initial data scripts at `src/main/resources/insert_movies.sql`
and `src/main/resources/insert_cinemas.sql`.

You can execute these scripts in your database to have some data to play with, otherwise you'll have
to insert the data yourself.

## API Endpoints

### Movie

#### Get All Movies

    URL: /api/v1/movie/all
    Method: GET
    Description: Retrieve a list of all movies.

#### Search Movies By Title

    URL: /api/v1/movie/search?title=avengers
    Method: GET
    Description: Retrieve a list of movies where the titles contains the value sent in the request parameter.

#### Get Movie by ID

    URL: /api/v1/movie/{id}
    Method: GET
    Description: Retrieve details of a specific movie by its ID.

#### Add a new Movie

    URL: /api/v1/movie
    Method: POST
    Description: Add a new movie to the database.

#### Update a Movie

    URL: /api/v1/movie/{id}
    Method: PUT
    Description: Update details of a specific movie by its ID.

#### Delete a Movie

    URL: /api/v1/movie/{id}
    Method: DELETE
    Description: Delete a specific movie by its ID.

### Cinema

#### Get All Cinemas

    URL: /api/v1/cinema/all
    Method: GET
    Description: Retrieve a list of all cinemas.

#### Get Cinema by ID

    URL: /api/v1/cinema/{id}
    Method: GET
    Description: Retrieve details of a specific cinema by its ID.

#### Add a new Cinema

    URL: /api/v1/cinema
    Method: POST
    Description: Add a new cinema to the database.

#### Update a Cinema

    URL: /api/v1/cinema/{id}
    Method: PUT
    Description: Update details of a specific cinema by its ID.

#### Delete a Cinema

    URL: /api/v1/cinema/{id}
    Method: DELETE
    Description: Delete a specific cinema by its ID.

### Schedule

#### Get the Schedule of a Cinema

    URL: /api/v1/schedule/{cinemaId}
    Method: GET
    Description: Retrieve details of a specific schedule by the cinema ID, we can also send the date as a request parameter

#### Search Schedules by movie title

    URL: /api/v1/schedule/search?movie=avengers
    Method: GET
    Description: Retrieve a list of schedules where the movie title contains the value sent in the request parameter.

#### Add a new Schedule

    URL: /api/v1/schedule
    Method: POST
    Description: Add a new schedule to the database.

## Author

Abdelhalim Jean

- https://www.linkedin.com/in/abdelhalimjean/
- https://www.youtube.com/c/ByteMauritanie
- https://www.facebook.com/bytemauritanie/

