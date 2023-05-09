package com.example.dailydoze.service.measurementService;

import com.example.dailydoze.model.Habit;
import com.example.dailydoze.model.Measurement;

import java.util.List;

public interface MeasurementService {
    Measurement saveMeasurement(Measurement measurement);


    void deleteMeasurementById(Long id);

    List<Measurement> getAllMeasurements();

    Measurement updateMeasurement(Measurement measurement);

    Measurement findById(Long id);

}
