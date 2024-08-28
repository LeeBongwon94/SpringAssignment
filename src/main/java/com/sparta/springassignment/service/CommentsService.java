package com.sparta.springassignment.service;

import com.sparta.springassignment.dto.CommentsRequestDto;
import com.sparta.springassignment.dto.CommentsResponseDto;
import com.sparta.springassignment.entity.Comments;
import com.sparta.springassignment.entity.Schedules;
import com.sparta.springassignment.repository.CommentsRepository;
import com.sparta.springassignment.repository.SchedulesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentsService {

    private final CommentsRepository commentsRepository;
    private final SchedulesRepository schedulesRepository;

    public CommentsResponseDto createComment(CommentsRequestDto requestDto, Long scheduleId) {
        Schedules schedules = schedulesRepository.findById(scheduleId).orElseThrow(NullPointerException::new);

        Comments comments = new Comments(requestDto);
        comments.setSchedules(schedules);

        Comments savedComments = commentsRepository.save(comments);
        return new CommentsResponseDto(savedComments);
    }

    // 댓글 전체 조회
    public List<CommentsResponseDto> getComments() {
        return commentsRepository.findAll().stream().map(CommentsResponseDto::new).toList();
    }

    // 댓글 단건 조회
    public CommentsResponseDto getComment(Long comment_id){
        Comments comments = commentsRepository.findById(comment_id).orElseThrow(NullPointerException::new);
        return new CommentsResponseDto(comments);
    }

    @Transactional
    public CommentsResponseDto updateComment(Long comment_id, CommentsRequestDto requestDto) {
        Comments comments = commentsRepository.findById(comment_id).orElseThrow(NullPointerException::new);
        comments.update(requestDto);

        return new CommentsResponseDto(comments);
    }

    public void deleteComment(Long comment_id){
        Comments comments = commentsRepository.findById(comment_id).orElseThrow(NullPointerException::new);
        commentsRepository.delete(comments);
    }
}
