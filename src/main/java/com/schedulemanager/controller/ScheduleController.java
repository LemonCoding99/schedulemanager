package com.schedulemanager.controller;

import com.schedulemanager.dto.*;
import com.schedulemanager.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ScheduleController {
    private final ScheduleService scheduleService;

    // 일정 생성(Create)
    @PostMapping("/schedules")
    public ResponseEntity<CreateScheduleResponseDto> createSchedule(@RequestBody CreateScheduleRequestDto request) {
        CreateScheduleResponseDto result = scheduleService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    // 일정 전체 조회(Get)
    @GetMapping("/schedules")
    public ResponseEntity<List<GetScheduleResponseDto>> getAll() {
        List<GetScheduleResponseDto> result = scheduleService.getALL();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    // 일정 단건 조회(Get)
    @GetMapping("/schedules/{scheduleId}")
    public ResponseEntity<GetOneScheduleResponseDto> getOne(@PathVariable Long scheduleId) {
        GetOneScheduleResponseDto result = scheduleService.getOne(scheduleId);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    // 일정 수정(Update)
    @PutMapping("/schedules/{scheduleId}")
    public ResponseEntity<UpdateScheduleResponseDto> update(
            @PathVariable Long scheduleId,  // URL 경로에 있는 scheduleId 값을 메서드 매개변수로 주입
            @RequestBody UpdateScheduleRequestDto request  // JSON을 UpdateScheduleRequestDto 객체로 변환
    ) {
        UpdateScheduleResponseDto result = scheduleService.update(scheduleId, request);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @DeleteMapping("schedules/{scheduleId}")
    public ResponseEntity<Void> delete(@PathVariable Long scheduleId) {
        scheduleService.delete(scheduleId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}