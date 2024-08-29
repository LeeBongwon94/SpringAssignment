package com.sparta.springassignment.service;

import com.sparta.springassignment.dto.UserRequestDto;
import com.sparta.springassignment.dto.UserResponseDto;
import com.sparta.springassignment.entity.Users;
import com.sparta.springassignment.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponseDto createUser(UserRequestDto requestDto){
        Users user = new Users(requestDto);
        Users savedUsers = userRepository.save(user);

        return new UserResponseDto(savedUsers);
    }

    // 유저 단건 조회
    public UserResponseDto getUser(Long user_id){
        Users user = usersFindById(user_id);
        return new UserResponseDto(user);
    }

    // 유저 전체 조회
    public List<UserResponseDto> getUsers(){
        return userRepository.findAll().stream().map(UserResponseDto::new).toList();
    }

    // 유저 수정
    @Transactional
    public UserResponseDto updateUser(Long user_id, UserRequestDto requestDto){
        Users user = usersFindById(user_id);
        user.update(requestDto);

        return new UserResponseDto(user);
    }

    // 유저 삭제
    public void deleteUser(Long user_id){
        Users user = usersFindById(user_id);
        userRepository.delete(user);
    }

    public Users usersFindById(Long user_id){
        return userRepository.findById(user_id).orElseThrow(NullPointerException::new);
    }
}
