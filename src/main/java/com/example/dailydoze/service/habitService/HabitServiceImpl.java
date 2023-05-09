package com.example.dailydoze.service.habitService;

import com.example.dailydoze.model.Habit;
import com.example.dailydoze.repository.HabitRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabitServiceImpl implements HabitService {


    private final HabitRepository habitRepository;

    public HabitServiceImpl(HabitRepository habitRepository) {
        this.habitRepository = habitRepository;
    }


    @Override
    public Habit saveHabit(Habit habit) {
        return habitRepository.save(habit);
    }

    @Override
    public void deleteHabitById(Long id) {
        habitRepository.deleteById(id);
    }

    @Override
    public List<Habit> getAllHabits() {
        return habitRepository.findAll();
    }

    @Override
    public Habit updateHabit(Habit habit) {
        return habitRepository.save(habit);
    }

    @Override
    public Habit findById(Long id) {
        return habitRepository.findById(id).orElse(null);
    }
}
