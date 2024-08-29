package com.sparta.springassignment.controller;

import com.sparta.springassignment.dto.UserRequestDto;
import com.sparta.springassignment.dto.UserResponseDto;
import com.sparta.springassignment.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    @PostMapping("/users")
    public UserResponseDto createUser(@RequestBody UserRequestDto requestDto){
        return userService.createUser(requestDto);
    }

    // 유저 단건 조회
    @GetMapping("/users/{user_id}")
    public UserResponseDto getUser(@PathVariable Long user_id){
        return userService.getUser(user_id);
    }

    // 유저 전체 조회
    @GetMapping("/users")
    public List<UserResponseDto> getUsers(){
        return userService.getUsers();
    }

    // 유저 수정
    @PutMapping("/users/{user_id}")
    public UserResponseDto updateUser(@PathVariable Long user_id, @RequestBody UserRequestDto requestDto){
        return userService.updateUser(user_id, requestDto);
    }

    // 유저 삭제
    @DeleteMapping("/users/{user_id}")
    public void deleteUser(@PathVariable Long user_id){
        userService.deleteUser(user_id);
    }
}
