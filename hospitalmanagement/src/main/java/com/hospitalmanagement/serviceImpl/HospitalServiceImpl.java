package com.hospitalmanagement.serviceImpl;
import com.hospitalmanagement.model.Hospital;
import com.hospitalmanagement.repository.HospitalRepository;
import com.hospitalmanagement.service.HospitalService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HospitalServiceImpl implements HospitalService {

    private final HospitalRepository repository;

    public HospitalServiceImpl(HospitalRepository repository) {
        this.repository = repository;
    }

    @Override
    public Hospital save(Hospital hospital) {
        return repository.save(hospital);
    }

    @Override
    public Optional<Hospital> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Hospital> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
