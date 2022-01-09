package com.mycode.bms.theatremgmt.repository;

import com.mycode.bms.theatremgmt.entity.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TheatreRepository extends JpaRepository<Theatre, Long> {

    Optional <Theatre> findByTheatreName(String theatreName);

}
