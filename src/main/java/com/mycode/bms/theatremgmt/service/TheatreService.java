package com.mycode.bms.theatremgmt.service;

import com.mycode.bms.theatremgmt.dao.TheatreDAO;
import com.mycode.bms.theatremgmt.entity.Movie;
import com.mycode.bms.theatremgmt.entity.Screen;
import com.mycode.bms.theatremgmt.entity.Theatre;
import com.mycode.bms.theatremgmt.model.GenericResponse;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Slf4j
@Service
public class TheatreService {

    private final TheatreDAO theatreDAO;

    public Theatre getTheatreByName(String theatreName) {
        return theatreDAO.getTheatreByName(theatreName);
    }

    public List< Theatre> loadAllTheatres() {
        final List<Theatre> theatreList = theatreDAO.loadAllTheatres();
        return theatreList;
    }

    public GenericResponse createTheatre(Theatre theatre) {
        Date currentDateTime = new Date(System.currentTimeMillis());
        theatre.setCreatedDate(currentDateTime);
        theatre.setModifiedDate(currentDateTime);
        theatreDAO.createTheatre(theatre);
        GenericResponse response = new GenericResponse();
        response.setMessage("Theatre created successfully!");
        return response;
    }

    public GenericResponse addScreen(Screen screen) {
        theatreDAO.addScreen(screen);
        GenericResponse response = new GenericResponse();
        response.setMessage("Screen added successfully!");
        return response;
    }

    public GenericResponse addMovie(Movie movie) {
        theatreDAO.addMovie(movie);
        GenericResponse response = new GenericResponse();
        response.setMessage("Movie added successfully!");
        return response;
    }

    public GenericResponse deleteTheatre(Long theatreId) {
        theatreDAO.deleteTheatre(theatreId);
        GenericResponse response = new GenericResponse();
        response.setMessage("Theatre deleted successfully!");
        return response;
    }

    public GenericResponse removeScreen(Long screenId) {
        theatreDAO.removeScreen(screenId);
        GenericResponse response = new GenericResponse();
        response.setMessage("Screen removed successfully!");
        return response;
    }

    public GenericResponse deleteMovie(Long movieId) {
        theatreDAO.deleteMovie(movieId);
        GenericResponse response = new GenericResponse();
        response.setMessage("Movie deleted successfully!");
        return response;
    }

    public List< Screen> loadAllScreens() {
        final List<Screen> screenList = theatreDAO.loadAllScreens();
        return screenList;
    }

    public List< Movie> loadAllMovies() {
        final List<Movie> movieList = theatreDAO.loadAllMovies();
        return movieList;
    }
}
