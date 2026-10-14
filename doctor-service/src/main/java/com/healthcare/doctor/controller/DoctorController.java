package com.healthcare.doctor.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/doctors")
public class DoctorController {
    private final List<Map<String, Object>> doctors = List.of(
        Map.of("id", 101, "name", "Dr. Ravi", "specialization", "Cardiology"),
        Map.of("id", 102, "name", "Dr. Meena", "specialization", "Neurology")
    );

    @GetMapping
    public List<Map<String, Object>> getDoctors() {
        return doctors;
    }

    @GetMapping("/{id}")
    public Map<String, Object> getDoctor(@PathVariable int id) {
        return doctors.stream()
            .filter(doctor -> doctor.get("id").equals(id))
            .findFirst()
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Doctor not found"));
    }
}
