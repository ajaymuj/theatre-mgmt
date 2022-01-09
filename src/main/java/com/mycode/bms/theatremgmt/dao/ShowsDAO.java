package com.mycode.bms.theatremgmt.dao;

import com.mycode.bms.theatremgmt.entity.Show;
import com.mycode.bms.theatremgmt.repository.ShowsRepository;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Data
@Slf4j
@Component
public class ShowsDAO {

    private final ShowsRepository showsRepository;

    public void addShow(Show show) {
        showsRepository.save(show);
    }

    public void removeShow(Long showId) {
        showsRepository.deleteById(showId);
    }
}
