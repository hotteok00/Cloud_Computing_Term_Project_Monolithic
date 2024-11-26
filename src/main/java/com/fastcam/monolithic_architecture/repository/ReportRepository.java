package com.fastcam.monolithic_architecture.repository;

import com.fastcam.monolithic_architecture.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository extends JpaRepository<Report, String> {
}
