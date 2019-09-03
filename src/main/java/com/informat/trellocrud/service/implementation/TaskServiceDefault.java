package com.informat.trellocrud.service.implementation;

import com.informat.trellocrud.model.Task;
import com.informat.trellocrud.model.enums.ListName;
import com.informat.trellocrud.repository.TaskRepository;
import com.informat.trellocrud.service.interfaces.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceDefault implements TaskService {

    @Autowired
    TaskRepository taskRepository;

    @Override
    public List<Task> getAllTasks() {
        List<Task> tasks = new ArrayList<>();
        taskRepository.findAll().forEach(tasks::add);
        return tasks;
    }

    @Override
    public List<Task> getTasksByList(ListName listname) {
        List<Task> tasks = new ArrayList<>();
        taskRepository.findAll().forEach(task -> {
            if (task.getListName().equals(listname))
                tasks.add(task);
        });
        return tasks;
    }

    @Override
    public Task getTaskById(int id) {
        Optional<Task> task = taskRepository.findById(id);
        return task.orElse(null);
    }

    @Override
    public Task saveOrUpdateTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public void deleteTask(int id) {
        taskRepository.deleteById(id);
    }
}
