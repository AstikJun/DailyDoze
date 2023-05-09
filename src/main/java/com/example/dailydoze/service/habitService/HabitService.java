package com.example.dailydoze.service.habitService;

import com.example.dailydoze.model.Habit;

import java.util.List;

public interface HabitService {

    Habit saveHabit(Habit habit);
    void deleteHabitById(Long id);
    List<Habit> getAllHabits();
    Habit updateHabit(Habit habit);
    Habit findById(Long id);

}
