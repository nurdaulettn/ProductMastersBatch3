package org.example.homeworks;

import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class MovieRepositoryImpl implements MovieRepository{

    private final List<Movie> movies = Arrays.asList(
            new Movie("Auru", "Kuka Beisen", 2025),
            new Movie("Interstellar", "Christopher Nolan", 2014),
            new Movie("Buisness Po Kazakhskie", "Nurlan Koyanbayev", 2022),
            new Movie("Buisness Po Kazakhskie V Brazilii", "Nurlan Koyanbayev", 2023)
    );

    @Override
    public List<Movie> getAllMovies(){
        return movies;
    }

    @Override
    public List<Movie> getMoviesByDirector(String director){
        return movies.stream().filter(movie -> movie.getDirector().equals(director)).toList();
    }
}
