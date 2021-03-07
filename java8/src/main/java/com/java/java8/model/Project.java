package com.java.java8.model;

import java.time.LocalDate;
import java.time.Period;

public class Project {

    String name;
    LocalDate startDate;
    Period period;
    Integer teamSize;

    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                ", startDate=" + startDate +
                ", period=" + period.getYears() +
                ", teamSize=" + teamSize +
                '}';
    }

    public Project(String name, LocalDate startDate, Period period, Integer teamSize) {
        this.name = name;
        this.startDate = startDate;
        this.period = period;
        this.teamSize = teamSize;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

    public Integer getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(Integer teamSize) {
        this.teamSize = teamSize;
    }
}