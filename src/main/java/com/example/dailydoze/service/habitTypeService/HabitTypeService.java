package com.example.dailydoze.service.habitTypeService;

import com.example.dailydoze.model.Habit;
import com.example.dailydoze.model.HabitType;

import java.util.List;

public interface HabitTypeService {
    HabitType saveHabit(HabitType habitType);
    void deleteHabitTypeById(Long id);
    List<HabitType> getAllHabitTypes();
    HabitType updateHabitType(HabitType habit);
    HabitType findById(Long id);
}
