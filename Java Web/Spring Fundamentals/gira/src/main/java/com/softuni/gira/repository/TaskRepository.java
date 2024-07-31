package com.softuni.gira.repository;

import com.softuni.gira.model.Progress;
import com.softuni.gira.model.entity.Task;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    Optional<Task> findByName(String name);
    Optional<Task> findByProgress(Progress progress);
    List<Task> findAllBy();
}
