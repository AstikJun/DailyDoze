package com.example.dailydoze.bootstrap;

import com.example.dailydoze.model.*;
import com.example.dailydoze.repository.*;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
@Component
public class MainBootstrap implements CommandLineRunner {

    private final UserRepository userRepository;
    private final ProfileRepository profileRepository;
    private final HabitRepository habitRepository;
    private final HabitTypeRepository habitTypeRepository;
    private final CalendarRepository  calendarRepository;
    private final MeasurementRepository measurementRepository;
    private final RoleRepository roleRepository;


    public MainBootstrap(UserRepository userRepository, ProfileRepository profileRepository, HabitRepository habitRepository, HabitTypeRepository habitTypeRepository, CalendarRepository calendarRepository, MeasurementRepository measurementRepository, RoleRepository roleRepository, UserRepository userRepository1) {
        this.userRepository = userRepository;
        this.profileRepository = profileRepository;
        this.habitRepository = habitRepository;
        this.habitTypeRepository = habitTypeRepository;
        this.calendarRepository = calendarRepository;
        this.measurementRepository = measurementRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Role role = new Role();
        role.setRole("USER");
        roleRepository.save(role);


        User user = new User();
        user.setRole(role);
        user.setName("Astan");
        user.setPassword("12345");
        user.setEmail("serikovastik@gmail.com");
        userRepository.save(user);


        Profile profile = new Profile();
        profile.setName("John Doe");
        profile.setIcon("user.png");
        profile.setLanguage("en");
        profile.setTheme("dark");
        profile.setUser(user);
        profileRepository.save(profile);

        HabitType habitType = new HabitType();
        habitType.setName("Walking");
        habitTypeRepository.save(habitType);

        Habit habit = new Habit();
        habit.setName("Walk in the park");
        habit.setDescription("Take a walk in the park for 30 minutes.");
        habit.setGoal(1);
        habit.setFrequency(1);
        habit.setStartDate(LocalDate.now());
        habit.setEndDate(LocalDate.now().plusMonths(6));
        habit.setUser(user);
        habit.setType(habitType);
        habitRepository.save(habit);

        Measurement measurement = new Measurement();
        measurement.setDate(LocalDate.now());
        measurement.setValue(5000);
        measurement.setHabit(habit);
        measurementRepository.save(measurement);

        Calendar calendar = new Calendar();
        calendar.setDate(LocalDate.now());
        calendar.setHabit(habit);
        calendarRepository.save(calendar);









    }
}
