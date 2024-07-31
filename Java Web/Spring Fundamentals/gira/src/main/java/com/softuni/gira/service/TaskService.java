package com.softuni.gira.service;

import com.softuni.gira.model.dto.AddTaskBindingModel;
import com.softuni.gira.model.dto.HomeViewDTO;
import com.softuni.gira.model.dto.TaskDTO;

public interface TaskService {

    boolean addTask(AddTaskBindingModel addTaskBindingModel);

    HomeViewDTO getTasks ();

    void progressManager(String name);
}
