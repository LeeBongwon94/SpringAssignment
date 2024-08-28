package com.sparta.springassignment.controller;

import com.sparta.springassignment.dto.SchedulesRequestDto;
import com.sparta.springassignment.dto.SchedulesResponseDto;
import com.sparta.springassignment.service.SchedulesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class SchedulesController {

    private final SchedulesService scheduleService;

    @PostMapping("/schedules")
    public SchedulesResponseDto createSchedule(@RequestBody SchedulesRequestDto requestDto){
        return scheduleService.createSchedule(requestDto);
    }

    @GetMapping("/schedules")
    public SchedulesResponseDto getSchedule(Long schedule_id){
        return scheduleService.getSchedule(schedule_id);
    }

    @PutMapping("/schedules/{schedule_id}")
    public SchedulesResponseDto editSchedule(@PathVariable Long schedule_id, @RequestBody SchedulesRequestDto requestDto){
        return scheduleService.updateSchedule(schedule_id, requestDto);
    }
}
