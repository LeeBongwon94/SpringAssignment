package com.sparta.springassignment.controller;

import com.sparta.springassignment.dto.SchedulesRequestDto;
import com.sparta.springassignment.dto.SchedulesResponseDto;
import com.sparta.springassignment.dto.UserResponseDto;
import com.sparta.springassignment.entity.Users;
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
    public SchedulesResponseDto updateSchedule(@PathVariable Long schedule_id, @RequestBody SchedulesRequestDto requestDto){
        return scheduleService.updateSchedule(schedule_id, requestDto);
    }

    // 일정 삭제
    @DeleteMapping("/schedules/{schedule_id}")
    public void deleteSchedule(@PathVariable Long schedule_id){
        scheduleService.deleteSchedule(schedule_id);
    }

    // 담당 유저 배치
    @PostMapping("/schedules/{schedule_id}/{user_id}")
    //public List<SchedulesResponseDto> addUser(@PathVariable Long schedule_id, @PathVariable Long user_id){
    public List<UserResponseDto> addUser(@PathVariable Long schedule_id, @PathVariable Long user_id){
        return scheduleService.addUser(schedule_id, user_id);
    }
}
