package com.mycode.bms.theatremgmt.controller;

import com.mycode.bms.theatremgmt.model.GenericResponse;
import com.mycode.bms.theatremgmt.model.ShowI;
import com.mycode.bms.theatremgmt.model.ShowModel;
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

    @PostMapping("/add/s1")
    public ResponseEntity < GenericResponse > createShow(@RequestBody @Validated ShowModel showModel) {
        GenericResponse response = screeningService.addShow(showModel);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/remove/s1")
    public ResponseEntity<?> removeShow(@RequestBody @Validated ShowI showI) {
        GenericResponse response = screeningService.removeShow(showI);
        return ResponseEntity.ok(response);
    }
}
