package com.mycode.bms.theatremgmt.repository;

import com.mycode.bms.theatremgmt.entity.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowsRepository extends JpaRepository< Show, Long> {


}
