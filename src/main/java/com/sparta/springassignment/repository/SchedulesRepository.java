package com.sparta.springassignment.repository;

import com.sparta.springassignment.entity.Schedules;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchedulesRepository extends JpaRepository<Schedules, Long> {

    Page<Schedules> findAll(Pageable pageable);
}
