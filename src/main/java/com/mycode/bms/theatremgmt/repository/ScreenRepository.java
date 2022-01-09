package com.mycode.bms.theatremgmt.repository;

import com.mycode.bms.theatremgmt.entity.Screen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScreenRepository extends JpaRepository<Screen, Long> {
}
