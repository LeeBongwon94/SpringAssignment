package com.sparta.springassignment.controller;

import com.sparta.springassignment.dto.CommentsRequestDto;
import com.sparta.springassignment.dto.CommentsResponseDto;
import com.sparta.springassignment.service.CommentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CommentsController {

    private final CommentsService commentsService;

    @PostMapping("/comments/{schedule_id}")
    public CommentsResponseDto createComment(@RequestBody CommentsRequestDto requestDto, @PathVariable Long schedule_id){
        return commentsService.createComment(requestDto, schedule_id);
    }

    // 댓글 전체 조회
    @GetMapping("/comments")
    List<CommentsResponseDto> getComments(){
        return commentsService.getComments();
    }

    // 댓글 단건 조회
    @GetMapping("/comments/{comment_id}")
    public CommentsResponseDto getComment(@PathVariable Long comment_id){
        return commentsService.getComment(comment_id);
    }

    // 댓글 수정
    @PutMapping("/comments")
    public CommentsResponseDto updateComment(@RequestParam Long comment_id, @RequestBody CommentsRequestDto requestDto){
        return commentsService.updateComment(comment_id, requestDto);
    }

    // 댓글 삭제
    @DeleteMapping("/comments")
    public void deleteComment(@RequestParam Long comment_id){
        commentsService.deleteComment(comment_id);
    }
}
