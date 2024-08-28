package com.sparta.springassignment.dto;

import com.sparta.springassignment.entity.Schedules;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class SchedulesResponseDto {
    String username;
    String title;
    String contents;
    LocalDateTime created_at;
    LocalDateTime updated_at;

    public SchedulesResponseDto(Schedules schedules){
        this.username = schedules.getUsername();
        this.title = schedules.getTitle();
        this.contents = schedules.getContents();
        this.created_at = schedules.getCreated_at();
        this.updated_at = schedules.getUpdated_at();
    }
}
