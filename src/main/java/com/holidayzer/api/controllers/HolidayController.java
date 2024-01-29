package com.holidayzer.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.holidayzer.api.Holiday;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/holidays")
public class HolidayController {
    List<Holiday> holiday = new ArrayList<>();

    HolidayController() {
        createHolidayList();
    }

    @GetMapping
    public List<Holiday> getHolidays() {
        return holiday;
    }

    @GetMapping("/{date}")
    public String getHolidayByDate(@PathVariable String date) {
        for (Holiday h : holiday) {
            if (h.getDate().equals(date)) {
                return "Dia " + h.getDate() + " é " + h.getName() + "! 🎉\n";
            }
        }
        return "Dia " + date + " não é feriado 🥲\n";
    }

    public void createHolidayList() {
        holiday.clear();
        holiday.add(new Holiday("01-01-2024", "Confraternização Mundial"));
        holiday.add(new Holiday("12-02-2024", "Carnaval"));
        holiday.add(new Holiday("13-02-2024", "Carnaval"));
        holiday.add(new Holiday("29-03-2024", "Sexta-feira Santa"));
        holiday.add(new Holiday("12-02-2024", "Tiradentes"));
        holiday.add(new Holiday("01-05-2024", "Dia do Trabalho"));
        holiday.add(new Holiday("30-05-2024", "Corpus Christi"));
        holiday.add(new Holiday("07-09-2024", "Independência do Brasil"));
        holiday.add(new Holiday("12-10-2024", "Nossa Senhora Aparecida"));
        holiday.add(new Holiday("02-11-2024", "Finados"));
        holiday.add(new Holiday("15-11-2024", "Proclamação da República"));
        holiday.add(new Holiday("20-11-2024", "Dia Nacional de Zumbi e da Consciência Negra"));
        holiday.add(new Holiday("25-12-2024", "Natal"));
    }
}
