package com.example.dailydoze.service.calendarService;

import com.example.dailydoze.model.Calendar;
import com.example.dailydoze.repository.CalendarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalendarServiceImpl implements CalendarService {

    private final CalendarRepository calendarRepository;

    public CalendarServiceImpl(CalendarRepository calendarRepository) {
        this.calendarRepository = calendarRepository;
    }

    @Override
    public Calendar saveCalendar(Calendar calendar) {
        return calendarRepository.save(calendar);
    }

    @Override
    public void deleteCalendarById(Long id) {
        calendarRepository.deleteById(id);
    }

    @Override
    public List<Calendar> getAllCalendars() {
        return calendarRepository.findAll();
    }

    @Override
    public Calendar updateCalendar(Calendar calendar) {
        return calendarRepository.save(calendar);
    }

    @Override
    public Calendar findById(Long id) {
        return calendarRepository.findById(id).orElse(null);
    }
}
