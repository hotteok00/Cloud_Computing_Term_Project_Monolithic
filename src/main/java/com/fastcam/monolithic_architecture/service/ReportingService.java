package com.fastcam.monolithic_architecture.service;

import com.fastcam.monolithic_architecture.model.Report;
import com.fastcam.monolithic_architecture.repository.ReportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReportingService {

    private final ReportRepository reportRepository;

    // 모든 보고서 조회
    public List<Report> getAllReports() {
        return reportRepository.findAll();
    }

    // 특정 보고서 조회
    public Optional<Report> getReportById(String id) {
        return reportRepository.findById(id);
    }
}
