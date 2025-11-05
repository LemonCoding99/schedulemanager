package com.schedulemanager.entity;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "schedules")
@NoArgsConstructor(access = AccessLevel.PROTECTED) // // 기본 생성자를 만들되, 외부에서는 함부로 호출하지 못하게 보호
public class Schedule extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본 키(@Id) 값을 자동으로 생성하는 방식
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String content;
    @Column(length = 50, nullable = false)
    private String name;
    @Column(nullable = false)
    private String password;

    // 생성자
    public Schedule(String title, String content, String name, String password) {
        this.title = title;
        this.content = content;
        this.name = name;
        this.password = password;
    }

    // 세터
    public void update(String title, String name, String password) {
        this.title = title;
        this.name = name;
        this.password = password;
    }
}

