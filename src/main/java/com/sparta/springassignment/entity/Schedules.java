package com.sparta.springassignment.entity;

import com.sparta.springassignment.dto.SchedulesRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "schedules")
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Schedules {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schedule_id;

    @Column(name = "title", nullable = false, length = 50)
    private String title;

    @Column(name = "user_id", nullable = false, length = 20)
    private Long user_id;

    @Column(name = "contents", nullable = false, length = 100)
    private String contents;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "schedules", cascade = CascadeType.REMOVE)
    private List<Comments> commentsList = new ArrayList<>();

    @OneToMany(mappedBy = "schedulesManage")
    private List<Manage> manageList = new ArrayList<>();

    public Schedules(SchedulesRequestDto requestDto){
        this.user_id = requestDto.getUser_id();
        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();
    }

    public void update(SchedulesRequestDto requestDto){
        this.user_id = requestDto.getUser_id();
        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();
    }
}
