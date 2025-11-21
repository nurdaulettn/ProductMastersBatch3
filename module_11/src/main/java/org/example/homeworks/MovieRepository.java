package org.example.homeworks;

import java.util.List;

public interface MovieRepository {
    List<Movie> getAllMovies();
    List<Movie> getMoviesByDirector(String director);
}
