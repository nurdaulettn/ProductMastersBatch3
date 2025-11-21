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

}
