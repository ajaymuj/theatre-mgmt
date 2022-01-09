package com.mycode.bms.theatremgmt.controller;

import com.mycode.bms.theatremgmt.entity.Movie;
import com.mycode.bms.theatremgmt.entity.Screen;
import com.mycode.bms.theatremgmt.entity.Theatre;
import com.mycode.bms.theatremgmt.model.GenericResponse;
import com.mycode.bms.theatremgmt.service.TheatreService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@Slf4j
@RestController
@RequestMapping("/theatre")
public class TheatreController {

    private final TheatreService theatreService;

    @GetMapping("/{theatreName}")
    public ResponseEntity < Theatre > getTheatreByName(@PathVariable("theatreName") String theatreName) {
        Theatre theatre = theatreService.getTheatreByName(theatreName);
        return ResponseEntity.ok(theatre);
    }

    @GetMapping("/tg1")
    public ResponseEntity < List <Theatre> > getAllTheatres() {
        List < Theatre > theatreList = theatreService.loadAllTheatres();
        return ResponseEntity.ok(theatreList);
    }

    @GetMapping("/ts1")
    public ResponseEntity < List <Screen> > getAllScreens() {
        List < Screen > screenList = theatreService.loadAllScreens();
        return ResponseEntity.ok(screenList);
    }

    @GetMapping("/tm1")
    public ResponseEntity < List <Movie> > getAllMovies() {
        List < Movie > movieList = theatreService.loadAllMovies();
        return ResponseEntity.ok(movieList);
    }

    @PostMapping("/create/t1")
    public ResponseEntity< GenericResponse > createTheatre(@RequestBody @Validated Theatre theatre) {
        GenericResponse response = theatreService.createTheatre(theatre);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/create/s1")
    public ResponseEntity< GenericResponse > addScreen(@RequestBody @Validated Screen screen) {
        GenericResponse response = theatreService.addScreen(screen);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/create/m1")
    public ResponseEntity< GenericResponse > addMovie(@RequestBody @Validated Movie movie) {
        GenericResponse response = theatreService.addMovie(movie);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/remove/t1/{theatreId}")
    public ResponseEntity<?> deleteTheatre(@PathVariable("theatreId") Long theatreId) {
        GenericResponse response = theatreService.deleteTheatre(theatreId);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/remove/s1/{screenId}")
    public ResponseEntity<?> removeScreen(@PathVariable("screenId") Long screenId) {
        GenericResponse response = theatreService.removeScreen(screenId);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/remove/m1/{movieId}")
    public ResponseEntity<?> deleteMovie(@PathVariable("movieId") Long movieId) {
        GenericResponse response = theatreService.deleteMovie(movieId);
        return ResponseEntity.ok(response);
    }

}
