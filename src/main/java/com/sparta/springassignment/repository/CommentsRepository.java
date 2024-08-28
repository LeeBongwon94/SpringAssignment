package com.sparta.springassignment.repository;

import com.sparta.springassignment.entity.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentsRepository extends JpaRepository<Comments, Long> {
}
