package com.example.dailydoze.service.habitTypeService;

import com.example.dailydoze.model.HabitType;
import com.example.dailydoze.repository.HabitTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabitTypeServiceImpl implements HabitTypeService {

    private final HabitTypeRepository habitTypeRepository;

    public HabitTypeServiceImpl(HabitTypeRepository habitTypeRepository) {
        this.habitTypeRepository = habitTypeRepository;
    }

    @Override
    public HabitType saveHabit(HabitType habitType) {
        return habitTypeRepository.save(habitType);
    }

    @Override
    public void deleteHabitTypeById(Long id) {
        habitTypeRepository.deleteById(id);
    }

    @Override
    public List<HabitType> getAllHabitTypes() {
        return habitTypeRepository.findAll();
    }

    @Override
    public HabitType updateHabitType(HabitType habit) {
        return habitTypeRepository.save(habit);
    }

    @Override
    public HabitType findById(Long id) {
        return habitTypeRepository.findById(id).orElse(null);
    }
}
