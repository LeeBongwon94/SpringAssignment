package com.sparta.springassignment.entity;

import com.sparta.springassignment.dto.CommentsRequestDto;
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
@Table(name = "comments")
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long comment_id;

    @Column(name = "contents", nullable = false, length = 100)
    private String contents;

    @Column(name = "comments_user", nullable = false, length = 20)
    private String comments_user;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "schedule_id")
    private Schedules schedules;

    public Comments(CommentsRequestDto requestDto){
        this.contents = requestDto.getContents();
        this.comments_user = requestDto.getComments_user();
    }

    public void update(CommentsRequestDto requestDto) {
        this.contents = requestDto.getContents();
    }
}
