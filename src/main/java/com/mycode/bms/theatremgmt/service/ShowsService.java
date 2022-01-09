package com.mycode.bms.theatremgmt.service;

import com.mycode.bms.theatremgmt.dao.ShowsDAO;
import com.mycode.bms.theatremgmt.entity.Show;
import com.mycode.bms.theatremgmt.model.GenericResponse;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Data
@Slf4j
@Service
public class ShowsService {

    private final ShowsDAO showsDAO;

    public GenericResponse addShow(Show show) {
        showsDAO.addShow(show);
        GenericResponse response = new GenericResponse();
        response.setMessage("Show added successfully!");
        return response;
    }

    public GenericResponse removeShow(Long showId) {
        showsDAO.removeShow(showId);
        GenericResponse response = new GenericResponse();
        response.setMessage("Show removed successfully!");
        return response;
    }
}
