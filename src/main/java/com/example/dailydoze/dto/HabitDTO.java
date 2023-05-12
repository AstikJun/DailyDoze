package com.example.dailydoze.dto;

import com.example.dailydoze.model.Calendar;
import com.example.dailydoze.model.HabitType;
import com.example.dailydoze.model.Measurement;
import com.example.dailydoze.model.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class HabitDTO {

    private String name;

    private String description;

    private Integer goal;

    private Integer frequency;

    private LocalDate startDate;

    private LocalDate endDate;

    private User user;

    private List<Measurement> measurements;

    private List<Calendar> calendarEntries;

    private HabitType type;
}
