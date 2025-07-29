package com.example.garage_backend.repository;

import com.example.garage_backend.model.FaultNote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FaultNoteRepository extends JpaRepository<FaultNote, Long> {
    List<FaultNote> findByCarId(Long carId);
}
