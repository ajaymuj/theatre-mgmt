package com.mycode.bms.theatremgmt.dao;

import com.mycode.bms.theatremgmt.entity.Movie;
import com.mycode.bms.theatremgmt.entity.Screen;
import com.mycode.bms.theatremgmt.entity.Theatre;
import com.mycode.bms.theatremgmt.exception.TheatreNotFoundException;
import com.mycode.bms.theatremgmt.repository.MovieRepository;
import com.mycode.bms.theatremgmt.repository.ScreenRepository;
import com.mycode.bms.theatremgmt.repository.TheatreRepository;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Data
@Slf4j
@Component
public class TheatreDAO {

    private final TheatreRepository theatreRepository;

    private final ScreenRepository screenRepository;

    private final MovieRepository movieRepository;

    public Theatre getTheatreByName(String theatreName) {
        Theatre theatre = theatreRepository.findByTheatreName(theatreName)
                .orElseThrow(() -> new TheatreNotFoundException(HttpStatus.NOT_FOUND, "Theatre Not Found!"));
        return theatre;
    }

    public List< Theatre> loadAllTheatres() {
        List<Theatre> theatreList = theatreRepository.findAll();
        return theatreList;
    }

    @Transactional
    public void createTheatre(Theatre theatre) {
        theatreRepository.save(theatre);
    }

    public void addScreen(Screen screen) {
        screenRepository.save(screen);
    }

    public void addMovie(Movie movie) {
        movieRepository.save(movie);
    }

    public void deleteTheatre(Long theatreId) {
        theatreRepository.deleteById(theatreId);
    }

    public void removeScreen(Long screenId) {
        screenRepository.deleteById(screenId);
    }

    public void deleteMovie(Long movieId) {
        movieRepository.deleteById(movieId);
    }

    public List< Screen> loadAllScreens() {
        List<Screen> screenList = screenRepository.findAll();
        return screenList;
    }

    public List< Movie> loadAllMovies() {
        List<Movie> movieList = movieRepository.findAll();
        return movieList;
    }
}
