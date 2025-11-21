package org.example.homeworks;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/by-director")
    public List<Movie> listMovies(@RequestParam("name") String director) {
        return movieService.getMoviesByDirector(director);
    }
}
