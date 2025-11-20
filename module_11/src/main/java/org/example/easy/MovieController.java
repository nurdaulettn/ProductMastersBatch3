package org.example.easy;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
@RequiredArgsConstructor
public class MovieController {
    private final MovieServiceImpl movieService;

    @GetMapping("/all")
    public List<Movie> listMovies() {
        return movieService.listMovies();
    }
}
