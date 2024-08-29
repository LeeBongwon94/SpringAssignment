package com.sparta.springassignment.repository;

import com.sparta.springassignment.entity.Manage;
import com.sparta.springassignment.entity.Schedules;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ManageRepository extends JpaRepository<Manage, Long> {
    Manage findBySchedulesManage(Schedules schedules);

    List<Manage> findAllBySchedulesManage(Schedules schedules);
}
