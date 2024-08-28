package com.sparta.springassignment.service;

import com.sparta.springassignment.dto.SchedulesRequestDto;
import com.sparta.springassignment.dto.SchedulesResponseDto;
import com.sparta.springassignment.entity.Schedules;
import com.sparta.springassignment.repository.SchedulesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    public List<SchedulesResponseDto> getSchedules(Pageable pageable) {
        //Pageable pageable = PageRequest.of(page, size, Sort.by(sort).descending());
        Page<Schedules> page = scheduleRepository.findAll(pageable);

        return new SchedulesResponseDto().toDtoList(page);
    }

    public void deleteSchedule(Long scheduleId) {
        Schedules schedules = scheduleRepository.findById(scheduleId).orElseThrow(NullPointerException::new);
        scheduleRepository.delete(schedules);
    }
}
