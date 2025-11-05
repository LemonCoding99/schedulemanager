package com.schedulemanager.dto;

import lombok.Getter;

@Getter
// 일정 생성 요청 dto
public class CreateScheduleRequestDto { // 저장 dto
    private String title;
    private String content;
    private String name;
    private String password;
}

