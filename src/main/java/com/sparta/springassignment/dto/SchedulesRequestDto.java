package com.sparta.springassignment.dto;

import com.sparta.springassignment.entity.Users;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SchedulesRequestDto {
    private Long user_id;
    private String title;
    private String contents;
}
