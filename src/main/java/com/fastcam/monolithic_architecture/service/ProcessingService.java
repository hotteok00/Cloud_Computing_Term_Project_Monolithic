package com.fastcam.monolithic_architecture.service;

import com.fastcam.monolithic_architecture.model.Feedback;
import com.fastcam.monolithic_architecture.model.Report;
import com.fastcam.monolithic_architecture.repository.FeedbackRepository;
import com.fastcam.monolithic_architecture.repository.ReportRepository;
import com.fastcam.monolithic_architecture.util.CsvUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProcessingService {

    private final FeedbackRepository feedbackRepository;
    private final ReportRepository reportRepository;
    private final S3Service s3Service;

    @Value("${aws.s3.bucket-name}")
    private String bucketName;

    public String processFeedbackData() throws IOException {
        // 1. 모든 피드백 데이터 가져오기
        List<Feedback> feedbackList = feedbackRepository.findAll();

        // 2. CSV 파일 생성
        String fileName = "processed_feedback_" + System.currentTimeMillis() + ".csv";
        File csvFile = CsvUtil.createCsvFile(feedbackList, fileName);

        // 3. S3에 업로드
        return s3Service.uploadFile(csvFile, fileName);
    }

    public void generateReport(String filePath) {
        try {
            String fileName = filePath.replace("https://cloud-computing-term-project-monolithic.s3.amazonaws.com/processed_feedback_", "");
            fileName = fileName.replace(".csv", "");

            // 2. Report 엔티티 생성 및 저장
            Report report = new Report(null, fileName, filePath, LocalDateTime.now());
            reportRepository.save(report);

        } catch (Exception e) {
            throw new RuntimeException("Failed to generate report", e);
        }
    }
}
