package com.fastcam.monolithic_architecture.controller;

import com.fastcam.monolithic_architecture.model.Feedback;
import com.fastcam.monolithic_architecture.service.CollectingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/collecting")
@RequiredArgsConstructor
public class CollectingController {

    private final CollectingService collectingService;

    // 피드백 저장
    @PostMapping
    public ResponseEntity<Feedback> saveFeedback(@RequestBody Feedback feedback) {
        return ResponseEntity.ok(collectingService.saveFeedback(feedback));
    }

    // 모든 피드백 조회
    @GetMapping
    public ResponseEntity<List<Feedback>> getAllFeedback() {
        return ResponseEntity.ok(collectingService.getAllFeedback());
    }
}
