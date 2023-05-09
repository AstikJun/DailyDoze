package com.example.dailydoze.service.calendarService;

import com.example.dailydoze.model.Calendar;
import com.example.dailydoze.model.Habit;

import java.util.List;

public interface CalendarService {
    Calendar saveCalendar(Calendar calendar);
    void deleteCalendarById(Long id);
    List<Calendar> getAllCalendars();
    Calendar updateCalendar(Calendar calendar);
    Calendar findById(Long id);
}
