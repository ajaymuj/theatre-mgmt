package com.mycode.bms.theatremgmt.repository;

import com.mycode.bms.theatremgmt.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
}
