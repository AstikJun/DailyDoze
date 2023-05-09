package com.example.dailydoze.service.measurementService;

import com.example.dailydoze.model.Measurement;
import com.example.dailydoze.model.Profile;
import com.example.dailydoze.repository.MeasurementRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

public class MeasurementServiceImpl implements MeasurementService {

    private final MeasurementRepository measurementRepository;

    public MeasurementServiceImpl(MeasurementRepository measurementRepository) {
        this.measurementRepository = measurementRepository;
    }

    @Override
    public Measurement saveMeasurement(Measurement measurement) {
        return measurementRepository.save(measurement);
    }

    @Override
    public void deleteMeasurementById(Long id) {
        measurementRepository.deleteById(id);
    }

    @Override
    public List<Measurement> getAllMeasurements() {
        return measurementRepository.findAll();
    }

    @Override
    public Measurement updateMeasurement(Measurement measurement) {
        return measurementRepository.save(measurement);
    }

    @Override
    public Measurement findById(Long id) {
        return measurementRepository.findById(id).orElse(null);
    }
}
