package com.mycode.bms.theatremgmt.controller;

import com.mycode.bms.theatremgmt.entity.Show;
import com.mycode.bms.theatremgmt.model.GenericResponse;
import com.mycode.bms.theatremgmt.service.ShowsService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Data
@Slf4j
@RestController
@RequestMapping("/shows")
public class ShowsController {

    private final ShowsService screeningService;

    @PostMapping("/add/t1")
    public ResponseEntity < GenericResponse > createShow(@RequestBody @Validated Show show) {
        GenericResponse response = screeningService.addShow(show);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/remove/s1/{showId}")
    public ResponseEntity<?> removeShow(@PathVariable("showId") Long showId) {
        GenericResponse response = screeningService.removeShow(showId);
        return ResponseEntity.ok(response);
    }
}
