package com.healthcare.patient.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/patients")
public class PatientController {
    private final List<Map<String, Object>> patients = List.of(
        Map.of("id", 1, "name", "Arun", "age", 25, "condition", "Fever"),
        Map.of("id", 2, "name", "Priya", "age", 30, "condition", "Cold")
    );

    @GetMapping
    public List<Map<String, Object>> getPatients() {
        return patients;
    }

    @GetMapping("/{id}")
    public Map<String, Object> getPatient(@PathVariable int id) {
        return patients.stream()
            .filter(patient -> patient.get("id").equals(id))
            .findFirst()
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Patient not found"));
    }
}
