package com.mycode.bms.theatremgmt.service;

import com.mycode.bms.theatremgmt.dao.ShowsDAO;
import com.mycode.bms.theatremgmt.entity.Show;
import com.mycode.bms.theatremgmt.entity.ShowPK;
import com.mycode.bms.theatremgmt.model.GenericResponse;
import com.mycode.bms.theatremgmt.model.ShowI;
import com.mycode.bms.theatremgmt.model.ShowModel;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Data
@Slf4j
@Service
public class ShowsService {

    private final ShowsDAO showsDAO;

    public GenericResponse addShow(ShowModel showModel) {
        Show show = new Show();
        ShowPK showPK = new ShowPK();
        showPK.setScreenId(showModel.getScreenId());
        showPK.setMovieId(showModel.getMovieId());
        show.setStartTime(showModel.getStartTime());
        show.setEndTime(showModel.getEndTime());
        showsDAO.addShow(show);
        GenericResponse response = new GenericResponse();
        response.setMessage("Show added successfully!");
        return response;
    }

    public GenericResponse removeShow(ShowI showI) {
        ShowPK showPK = new ShowPK();
        showPK.setScreenId(showI.getScreenId());
        showPK.setMovieId(showI.getMovieId());
        showsDAO.removeShow(showPK);
        GenericResponse response = new GenericResponse();
        response.setMessage("Show removed successfully!");
        return response;
    }
}
