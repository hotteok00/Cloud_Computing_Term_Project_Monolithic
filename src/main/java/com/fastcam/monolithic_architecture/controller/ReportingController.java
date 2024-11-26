package com.fastcam.monolithic_architecture.controller;

import com.fastcam.monolithic_architecture.model.Report;
import com.fastcam.monolithic_architecture.service.ReportingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/reporting")
@RequiredArgsConstructor
public class ReportingController {

    private final ReportingService reportingService;

    // 모든 보고서 목록 조회
    @GetMapping
    public ResponseEntity<List<Report>> getAllReports() {
        List<Report> reports = reportingService.getAllReports();
        return ResponseEntity.ok(reports);
    }

    // 특정 보고서 조회
    @GetMapping("/{id}")
    public ResponseEntity<Report> getReportById(@PathVariable String id) {
        return reportingService.getReportById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
