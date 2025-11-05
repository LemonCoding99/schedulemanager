package com.schedulemanager.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class GetScheduleResponseDto {

    // 작성자명을 기준으로 등록된 일정 목록 전부 조회
    // 수정일 기준 내림차순 정렬
    // API 응답에 비밀번호 제외

    private final Long id;
    private final String title;
    private final String content;
    private final String name;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public GetScheduleResponseDto(Long id, String title, String content, String name, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.name = name;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
