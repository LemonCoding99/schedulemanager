package com.schedulemanager.controller;

import com.schedulemanager.dto.*;
import com.schedulemanager.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ScheduleController {
    private final ScheduleService scheduleService;

    // 일정 생성(Create)
    @PostMapping("/schedules")
    public CreateScheduleResponseDto createSchedule(@RequestBody CreateScheduleRequestDto request) {
        return scheduleService.save(request);
    }

    // 일정 전체 조회(Get)
    @GetMapping("/schedules")
    public List<GetScheduleResponseDto> getSchedules() {
        return scheduleService.getALL();
    }

    // 일정 단건 조회(Get)
    @GetMapping("/schedules/{scheduleId}")
    public GetOneScheduleResponseDto getOneSchedule(@PathVariable Long scheduleId) {
        return scheduleService.getOne(scheduleId);
    }

    // 일정 수정(Update)
    @PutMapping("/schedules/{scheduleId}")
    public UpdateScheduleResponseDto update(
            @PathVariable Long scheduleId,  // URL 경로에 있는 scheduleId 값을 메서드 매개변수로 주입
            @RequestBody UpdateScheduleRequestDto request  // JSON을 UpdateScheduleRequestDto 객체로 변환
    ) {
        return scheduleService.update(scheduleId, request);
    }

    @DeleteMapping("schedules/{scheduleId}")
    public void delete(@PathVariable Long scheduleId) {
        scheduleService.delete(scheduleId);
    }
}