package com.hospitalmanagement.service;

import com.hospitalmanagement.model.Hospital;

import java.util.List;
import java.util.Optional;

public interface HospitalService {
    Hospital save(Hospital hospital);
    Optional<Hospital> findById(Long id);
    List<Hospital> findAll();
    void deleteById(Long id);
}
