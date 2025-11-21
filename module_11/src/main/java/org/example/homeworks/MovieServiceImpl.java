package org.example.homeworks;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    @Override
    public List<Movie> listMovies() {
        return movieRepository.getAllMovies();
    }

    @Override
    public List<Movie> getMoviesByDirector(String director) {
        return movieRepository.getMoviesByDirector(director);
    }

    @Override
    public void addMovie(Movie movie) {
        validateMovie(movie);
        movieRepository.addMovie(movie);
    }

    private void validateMovie(Movie movie) {
        if(movie.getDirector() == null || movie.getDirector().isEmpty()) {
            throw new IllegalArgumentException("Movie must have a director");
        }

        if(movie.getTitle() == null || movie.getTitle().isEmpty()) {
            throw new IllegalArgumentException("Movie must have a title");
        }

        if(movie.getYear() < 1900){
            throw new IllegalArgumentException("Year must be >= 1900");
        }
    }

}
