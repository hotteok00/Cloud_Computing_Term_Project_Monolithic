package com.fastcam.monolithic_architecture.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String responder;   // 응답자
    private int satisfaction;   // 만족도
    private int convenience;    // 사용 편의성
    private int usefulness;     // 기능 유용성
    private int stability;      // 안정성

    @CreationTimestamp
    private LocalDateTime createdAt;
}
