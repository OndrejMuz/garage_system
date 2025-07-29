package com.example.garage_backend.service;

import com.example.garage_backend.model.Car;
import com.example.garage_backend.model.FaultNote;
import com.example.garage_backend.repository.CarRepository;
import com.example.garage_backend.repository.FaultNoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class FaultNoteService {

    @Autowired
    private FaultNoteRepository faultNoteRepository;

    @Autowired
    private CarRepository carRepository;

    public FaultNote addFaultNoteToCar(Long carId, FaultNote note) {
        Car car = carRepository.findById(carId)
                .orElseThrow(() -> new RuntimeException("Car not found"));
        note.setCar(car);
        note.setCreatedAt(LocalDate.now());
        return faultNoteRepository.save(note);
    }

    public List<FaultNote> getNotesByCarId(Long carId) {
        return faultNoteRepository.findByCarId(carId);
    }

    public Optional<FaultNote> toggleRepairedStatus(Long id) {
        return faultNoteRepository.findById(id).map(note -> {
            note.setRepaired(!note.isRepaired());  // 🔁 toggle it
            return faultNoteRepository.save(note);
        });
    }

}

