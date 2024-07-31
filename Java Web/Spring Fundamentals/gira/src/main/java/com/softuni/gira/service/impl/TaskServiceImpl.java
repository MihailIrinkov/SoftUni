package com.softuni.gira.service.impl;

import com.softuni.gira.model.ClassificaionName;
import com.softuni.gira.model.Progress;
import com.softuni.gira.model.dto.AddTaskBindingModel;
import com.softuni.gira.model.dto.HomeViewDTO;
import com.softuni.gira.model.dto.TaskDTO;
import com.softuni.gira.model.dto.UserDTO;
import com.softuni.gira.model.entity.Classification;
import com.softuni.gira.model.entity.Task;
import com.softuni.gira.model.entity.User;
import com.softuni.gira.repository.ClassificationRepository;
import com.softuni.gira.repository.TaskRepository;
import com.softuni.gira.repository.UserRepository;
import com.softuni.gira.service.LoggedUser;
import com.softuni.gira.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

    private final LoggedUser loggedUser;
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    private final ClassificationRepository classificationRepository;

    public TaskServiceImpl(LoggedUser loggedUser,
                           TaskRepository taskRepository,
                           UserRepository userRepository,
                           ClassificationRepository classificationRepository) {
        this.loggedUser = loggedUser;
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
        this.classificationRepository = classificationRepository;
    }

    @Override
    public boolean addTask(AddTaskBindingModel addTaskBindingModel) {

        Optional<Task> taskByName = this.taskRepository.findByName(addTaskBindingModel.getName());

        UserDTO userDTO = new UserDTO().setName(loggedUser.getUsername());

        if (taskByName.isPresent()) {
            return false;
        }

        User user = this.userRepository.findByUsername(loggedUser.getUsername()).get();

        Classification classification =
                this.classificationRepository
                        .findByClassificaionName(ClassificaionName.valueOf(addTaskBindingModel.getClassification())).get();

        Task taskToSave = new Task()
                .setProgress(Progress.OPEN)
                .setName(addTaskBindingModel.getName())
                .setUser(user)
                .setDescription(addTaskBindingModel.getDescription())
                .setDueDate(addTaskBindingModel.getDueDate())
                .setClassification(classification);

        this.taskRepository.save(taskToSave);

        return true;
    }

    @Override
    public HomeViewDTO getTasks() {
        UserDTO userDTO = new UserDTO().setName(loggedUser.getUsername());

        List<TaskDTO> taskDTOS = this.taskRepository.findAllBy()
                .stream()
                .map(task -> new TaskDTO()
                        .setName(task.getName())
                        .setClassification(this.classificationRepository
                                .findByClassificaionName(task.getClassification()
                                        .getClassificaionName()).get().getClassificaionName().toString())
                        .setProgress(task.getProgress())
                        .setDueDate(task.getDueDate())
                        .setUser(userDTO))
                .collect(Collectors.toList());

        HomeViewDTO homeViewDTO = new HomeViewDTO()
                .setTasks(taskDTOS);

        return homeViewDTO;
    }

    @Override
    public void progressManager(String name) {

        Task taskToManage = this.taskRepository.findByName(name).get();

        if (taskToManage.getProgress().toString().equals("OPEN")) {
            taskToManage.setProgress(Progress.IN_PROGRESS);
            this.taskRepository.save(taskToManage);
        } else if (taskToManage.getProgress().toString().equals("IN_PROGRESS")) {
            taskToManage.setProgress(Progress.COMPLETED);
            this.taskRepository.save(taskToManage);
        } else if (taskToManage.getProgress().toString().equals("COMPLETED")) {
            this.taskRepository.delete(taskToManage);
        }

    }


}
