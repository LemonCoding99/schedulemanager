package com.schedulemanager.service;

import com.schedulemanager.dto.*;
import com.schedulemanager.entity.Schedule;
import com.schedulemanager.repository.ScheduleRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;

    // 일정 생성
    @Transactional
    public CreateScheduleResponseDto save(CreateScheduleRequestDto request) {
        Schedule schedule = new Schedule(
                request.getTitle(),
                request.getContent(),
                request.getName(),
                request.getPassword()
        );
        Schedule savedSchedule = scheduleRepository.save(schedule);
        return new CreateScheduleResponseDto(
                savedSchedule.getId(),
                savedSchedule.getTitle(),
                savedSchedule.getContent(),
                savedSchedule.getName(),
                savedSchedule.getCreatedAt(),
                savedSchedule.getModifiedAt()
        );
    }

    // 일정 전체 조회
    @Transactional(readOnly = true)
    public List<GetScheduleResponseDto> getALL() {
        List<Schedule> schedules = scheduleRepository.findAll();
        List<GetScheduleResponseDto> dtos = new ArrayList<>();

        for (Schedule schedule : schedules) {
            GetScheduleResponseDto dto = new GetScheduleResponseDto(
                    schedule.getId(),
                    schedule.getTitle(),
                    schedule.getContent(),
                    schedule.getName(),
                    schedule.getCreatedAt(),
                    schedule.getModifiedAt()
            );
            dtos.add(dto);  // 생성한 객체 리스트에 추가
        }
        return dtos;
    }

    // 일정 단건 조회
    @Transactional(readOnly = true)
    public GetOneScheduleResponseDto getOne(Long scheduleId) {
        // null 일 경우 예외처리 해주기
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(
                () -> new IllegalStateException("존재하지 않는 유저입니다.")
        );
        return new GetOneScheduleResponseDto(
                schedule.getId(),
                schedule.getTitle(),
                schedule.getContent(),
                schedule.getName(),
                schedule.getCreatedAt(),
                schedule.getModifiedAt()
        );
    }

    // 일정 수정
    @Transactional
    public UpdateScheduleResponseDto update(Long scheduleId, UpdateScheduleRequestDto request) {
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(
                () -> new IllegalStateException("존재하지 않는 유저입니다.")
        );
        schedule.update(
                request.getTitle(),
                request.getName(),
                request.getPassword()
        );
        return new UpdateScheduleResponseDto(
                schedule.getId(),
                schedule.getTitle(),
                schedule.getContent(),
                schedule.getName(),
                schedule.getCreatedAt(),
                schedule.getModifiedAt()
        );
    }

    // 일정 삭제
    @Transactional
    public void delete(Long scheduleId) {
        boolean existence = scheduleRepository.existsById(scheduleId);
        // 유저가 없는 경우
        if (!existence) {
            throw new IllegalStateException("존재하지 않는 유저입니다.");
        }
        // 유저가 있는 경우 삭제 가능
        scheduleRepository.deleteById(scheduleId);
    }

}
