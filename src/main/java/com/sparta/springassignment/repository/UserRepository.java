package com.sparta.springassignment.repository;

import com.sparta.springassignment.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
}
