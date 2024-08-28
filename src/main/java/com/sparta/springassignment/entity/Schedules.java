package com.sparta.springassignment.entity;

import com.sparta.springassignment.dto.SchedulesRequestDto;
import com.sparta.springassignment.dto.SchedulesResponseDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "schedules")
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Schedules {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long schedule_id;

    @Column(name = "username", nullable = false, length = 20)
    String username;

    @Column(name = "title", nullable = false, length = 50)
    String title;

    @Column(name = "contents", nullable = false, length = 100)
    String contents;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    LocalDateTime created_at;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    LocalDateTime updated_at;

    public Schedules(SchedulesRequestDto requestDto){
        this.username = requestDto.getUsername();
        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();
    }

    public void update(SchedulesRequestDto requestDto){
        this.username = requestDto.getUsername();
        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();
    }
}
