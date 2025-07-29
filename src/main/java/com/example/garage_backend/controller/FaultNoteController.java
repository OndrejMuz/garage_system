package com.example.garage_backend.controller;


import com.example.garage_backend.model.FaultNote;
import com.example.garage_backend.service.FaultNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
public class FaultNoteController {

    @Autowired
    private FaultNoteService faultNoteService;

    @PostMapping("/car/{carId}")
    public FaultNote addNote(@PathVariable Long carId, @RequestBody FaultNote note){
        return faultNoteService.addFaultNoteToCar(carId, note);
    }

    @GetMapping("/car/{carId}")
    public List<FaultNote> getNotes(@PathVariable Long carId) {
        return faultNoteService.getNotesByCarId(carId);
    }
}
