package com.sparta.springassignment.dto;

import com.sparta.springassignment.entity.Manage;
import com.sparta.springassignment.entity.Users;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class UserResponseDto {
    private String username;
    private String email;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;

    public UserResponseDto(Users users){
        this.username = users.getUsername();
        this.email = users.getEmail();
        this.createAt = users.getCreateAt();
        this.updateAt = users.getUpdateAt();
    }

    public UserResponseDto(Manage manage) {
        this.username = manage.getUsers().getUsername();
        this.email = manage.getUsers().getEmail();
        this.createAt = manage.getUsers().getCreateAt();
        this.updateAt = manage.getUsers().getUpdateAt();
    }
}
