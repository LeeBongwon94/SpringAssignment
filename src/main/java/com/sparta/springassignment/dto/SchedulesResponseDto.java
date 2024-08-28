package com.sparta.springassignment.dto;

import com.sparta.springassignment.entity.Schedules;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SchedulesResponseDto {
    String username;
    String title;
    String contents;
    int comment_cnt;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;

    public SchedulesResponseDto(Schedules schedules){
        this.username = schedules.getUsername();
        this.title = schedules.getTitle();
        this.contents = schedules.getContents();
        this.createdAt = schedules.getCreatedAt();
        this.updatedAt = schedules.getUpdatedAt();
    }

    // page<Schedules> 을 List<SchedulesResponseDto> 로 반환
    public List<SchedulesResponseDto> toDtoList(Page<Schedules> schedules){
        Page<SchedulesResponseDto> dtoList = schedules.map(a -> new SchedulesResponseDto(
            a.getTitle(),
            a.getContents(),
            a.getUsername(),
            a.getCommentsList().size(), // 댓글 갯수
            a.getCreatedAt(),
            a.getUpdatedAt()
        ));

        return dtoList.getContent();
    }
}
