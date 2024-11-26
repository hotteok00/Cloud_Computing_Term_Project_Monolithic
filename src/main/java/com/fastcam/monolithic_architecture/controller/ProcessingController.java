package com.fastcam.monolithic_architecture.controller;

import com.fastcam.monolithic_architecture.model.Report;
import com.fastcam.monolithic_architecture.service.ProcessingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/processing")
@RequiredArgsConstructor
public class ProcessingController {

    private final ProcessingService processingService;

    @GetMapping
    public ResponseEntity<String> processFeedback() {
        try {
            String filePath = processingService.processFeedbackData();
            processingService.generateReport(filePath);

            return ResponseEntity.ok("File processed and saved to S3: " + filePath);
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Failed to process feedback.");
        }
    }
}
