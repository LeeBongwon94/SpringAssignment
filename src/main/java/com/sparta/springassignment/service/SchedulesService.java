package com.sparta.springassignment.service;

import com.sparta.springassignment.dto.SchedulesRequestDto;
import com.sparta.springassignment.dto.SchedulesResponseDto;
import com.sparta.springassignment.dto.UserRequestDto;
import com.sparta.springassignment.dto.UserResponseDto;
import com.sparta.springassignment.entity.Manage;
import com.sparta.springassignment.entity.Schedules;
import com.sparta.springassignment.entity.Users;
import com.sparta.springassignment.repository.ManageRepository;
import com.sparta.springassignment.repository.SchedulesRepository;
import com.sparta.springassignment.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchedulesService {

    private final ManageRepository manageRepository;
    private final SchedulesRepository scheduleRepository;
    private final UserRepository userRepository;

    public SchedulesResponseDto createSchedule(SchedulesRequestDto requestDto) {
        Schedules schedules = new Schedules(requestDto);
        Users users = userRepository.findById(requestDto.getUser_id()).orElseThrow(NullPointerException::new);
        Manage manage = new Manage();
        manage.setSchedulesManage(schedules);
        manage.setUsers(users);

        Schedules savedSchedule = scheduleRepository.save(schedules);
        manageRepository.save(manage);

        return new SchedulesResponseDto(savedSchedule);
    }

    public SchedulesResponseDto getSchedule(Long schedule_id) {
        Schedules schedules = schedulesFindById(schedule_id);
        return new SchedulesResponseDto(schedules);
    }

    @Transactional
    public SchedulesResponseDto updateSchedule(Long schedule_id, SchedulesRequestDto requestDto){
        Schedules schedules = schedulesFindById(schedule_id);
        schedules.update(requestDto);
        return new SchedulesResponseDto(schedules);
    }

    public List<SchedulesResponseDto> getSchedules(Pageable pageable) {
        //Pageable pageable = PageRequest.of(page, size, Sort.by(sort).descending());
        Page<Schedules> page = scheduleRepository.findAll(pageable);

        return new SchedulesResponseDto().toDtoList(page);
    }

    public void deleteSchedule(Long schedule_id) {
        Schedules schedules = schedulesFindById(schedule_id);
        scheduleRepository.delete(schedules);
    }

    @Transactional
    public List<UserResponseDto> addUser(Long schedule_id, Long user_id) {
        Schedules schedules = schedulesFindById(schedule_id);
        Users users = userRepository.findById(user_id).orElseThrow(NullPointerException::new);

        Manage manage = new Manage();
        manage.setUsers(users);
        manage.setSchedulesManage(schedules);
        manageRepository.save(manage);

        List<UserResponseDto> userList = manageRepository.findAllBySchedulesManage(schedules).stream().map(UserResponseDto::new).toList();

        return userList;
    }

    public Schedules schedulesFindById(Long schedule_id){
        return scheduleRepository.findById(schedule_id).orElseThrow(NullPointerException::new);
    }
}