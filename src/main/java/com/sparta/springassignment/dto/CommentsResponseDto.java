package com.sparta.springassignment.dto;

import com.sparta.springassignment.entity.Comments;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentsResponseDto {
    private String contents;
    private String comments_user;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Long schedule_id;

    public CommentsResponseDto(Comments comments){
        this.contents = comments.getContents();
        this.comments_user = comments.getComments_user();
        this.createdAt = comments.getCreatedAt();
        this.updatedAt = comments.getUpdatedAt();
        this.schedule_id = comments.getSchedules().getSchedule_id();
    }
}
