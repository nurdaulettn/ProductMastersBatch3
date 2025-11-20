package org.example.easy;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MovieRepositoryImpl implements MovieRepository{

    private final List<Movie> movies = Arrays.asList(
            new Movie("Auru", "Kuka Beisen", 2025),
            new Movie("Interstellar", "Christopher Nolan", 2014),
            new Movie("Buisness Po Kazakhskie", "Nurlan Koyanbayev", 2022)
    );

    @Override
    public List<Movie> getAllMovies(){
        return movies;
    }
}
