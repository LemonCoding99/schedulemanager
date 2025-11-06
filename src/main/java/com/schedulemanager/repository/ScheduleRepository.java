package com.schedulemanager.repository;

import com.schedulemanager.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// // 이 Repository는 Schedule 엔티티를 다루고, 기본키(Primary Key)는 Long 타입
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    List<Schedule> findAllByNameOrderByModifiedAtDesc(String name);  // DB접근 로직으로 DB에서 실제 데이터 조회
}
