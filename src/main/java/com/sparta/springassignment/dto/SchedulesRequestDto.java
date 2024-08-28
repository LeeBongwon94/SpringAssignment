package com.sparta.springassignment.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SchedulesRequestDto {
    String username;
    String title;
    String contents;
}
