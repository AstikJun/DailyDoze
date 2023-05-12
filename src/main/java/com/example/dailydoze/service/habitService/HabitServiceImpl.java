package com.example.dailydoze.service.habitService;

import com.example.dailydoze.model.Habit;
import com.example.dailydoze.model.User;
import com.example.dailydoze.repository.*;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabitServiceImpl implements HabitService {
    private final UserRepository userRepository;

    private final ProfileRepository profileRepository;

    private final MeasurementRepository measurementRepository;

    private final CalendarRepository calendarRepository;

    private final HabitTypeRepository habitTypeRepository;

    private final HabitRepository habitRepository;

    public HabitServiceImpl(UserRepository userRepository, ProfileRepository profileRepository, MeasurementRepository measurementRepository, CalendarRepository calendarRepository, HabitTypeRepository habitTypeRepository, HabitRepository habitRepository) {
        this.userRepository = userRepository;
        this.profileRepository = profileRepository;
        this.measurementRepository = measurementRepository;
        this.calendarRepository = calendarRepository;
        this.habitTypeRepository = habitTypeRepository;
        this.habitRepository = habitRepository;
    }
//    public HabitServiceImpl(HabitRepository habitRepository) {
//        this.habitRepository = habitRepository;
//    }



    @Override
    public Habit saveHabit(Habit habit) {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        org.springframework.security.core.userdetails.User user =
              (org.springframework.security.core.userdetails.User) securityContext.getAuthentication().getPrincipal();
        com.example.dailydoze.model.User users = userRepository.findByEmail(user.getUsername());


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
