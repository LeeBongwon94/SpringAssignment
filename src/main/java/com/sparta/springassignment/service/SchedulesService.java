package com.sparta.springassignment.service;

import com.sparta.springassignment.dto.SchedulesRequestDto;
import com.sparta.springassignment.dto.SchedulesResponseDto;
import com.sparta.springassignment.entity.Schedules;
import com.sparta.springassignment.repository.SchedulesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SchedulesService {

    private final SchedulesRepository scheduleRepository;

    public SchedulesResponseDto createSchedule(SchedulesRequestDto requestDto) {
        Schedules schedules = new Schedules(requestDto);
        Schedules savedSchedule = scheduleRepository.save(schedules);

        return new SchedulesResponseDto(savedSchedule);
    }

    public SchedulesResponseDto getSchedule(Long id) {
        Schedules schedules = scheduleRepository.findById(id).orElseThrow(NullPointerException::new);
        return new SchedulesResponseDto(schedules);
    }

    @Transactional
    public SchedulesResponseDto updateSchedule(Long id, SchedulesRequestDto requestDto){
        Schedules schedules = scheduleRepository.findById(id).orElseThrow(NullPointerException::new);
        schedules.update(requestDto);
        return new SchedulesResponseDto(schedules);
    }
}
