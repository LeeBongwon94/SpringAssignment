package com.sparta.springassignment.controller;

import com.sparta.springassignment.dto.SchedulesRequestDto;
import com.sparta.springassignment.dto.SchedulesResponseDto;
import com.sparta.springassignment.service.SchedulesService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class SchedulesController {

    private final SchedulesService scheduleService;

    // 일정 생성
    @PostMapping("/schedules")
    public SchedulesResponseDto createSchedule(@RequestBody SchedulesRequestDto requestDto){
        return scheduleService.createSchedule(requestDto);
    }

    // 일정 단건 조회
    @GetMapping("/schedules/{schedule_id}")
    public SchedulesResponseDto getSchedule(@PathVariable Long schedule_id){
        return scheduleService.getSchedule(schedule_id);
    }

    // 일정 페이지네이션
    @GetMapping("/schedules")
    public List<SchedulesResponseDto> getSchedules(@PageableDefault(
            page = 0,
            size = 10,
            sort = "updatedAt",
            direction = Sort.Direction.DESC) Pageable pageable){
        return scheduleService.getSchedules(pageable);
    }

    // 일정 수정
    @PutMapping("/schedules/{schedule_id}")
    public SchedulesResponseDto editSchedule(@PathVariable Long schedule_id, @RequestBody SchedulesRequestDto requestDto){
        return scheduleService.updateSchedule(schedule_id, requestDto);
    }
}
