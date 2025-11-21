package org.example.homeworks;

import java.util.List;

public interface MovieService {
    List<Movie> listMovies();
    List<Movie> getMoviesByDirector(String director);
}
