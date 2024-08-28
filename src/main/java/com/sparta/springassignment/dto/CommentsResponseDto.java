package com.sparta.springassignment.dto;

import com.sparta.springassignment.entity.Comments;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
public class CommentsResponseDto {
    String contents;
    String comments_user;
    LocalDateTime created_at;
    LocalDateTime updated_at;
    Long schedule_id;

    public CommentsResponseDto(Comments comments){
        this.contents = comments.getContents();
        this.comments_user = comments.getComments_user();
        this.created_at = comments.getCreated_at();
        this.updated_at = comments.getUpdated_at();
        this.schedule_id = comments.getSchedules().getSchedule_id();
    }
}
