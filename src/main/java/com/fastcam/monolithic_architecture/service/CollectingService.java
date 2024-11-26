package com.fastcam.monolithic_architecture.service;

import com.fastcam.monolithic_architecture.model.Feedback;
import com.fastcam.monolithic_architecture.repository.FeedbackRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CollectingService {

    private final FeedbackRepository feedbackRepository;

    // 피드백 저장
    public Feedback saveFeedback(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    // 모든 피드백 조회
    public List<Feedback> getAllFeedback() {
        return feedbackRepository.findAll();
    }
}

