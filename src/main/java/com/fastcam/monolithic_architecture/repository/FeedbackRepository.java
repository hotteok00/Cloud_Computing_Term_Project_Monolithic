package com.fastcam.monolithic_architecture.repository;

import com.fastcam.monolithic_architecture.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, String> {
}
