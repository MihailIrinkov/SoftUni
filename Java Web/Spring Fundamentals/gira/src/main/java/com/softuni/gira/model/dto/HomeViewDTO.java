package com.softuni.gira.model.dto;

import java.util.ArrayList;
import java.util.List;

public class HomeViewDTO {

    private List<TaskDTO> tasks;

    public HomeViewDTO() {
        tasks = new ArrayList<>();
    }

    public List<TaskDTO> getTasks() {
        return tasks;
    }

    public HomeViewDTO setTasks(List<TaskDTO> tasks) {
        this.tasks = tasks;
        return this;
    }
}
