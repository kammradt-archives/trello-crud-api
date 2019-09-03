package com.informat.trellocrud.service.interfaces;

import com.informat.trellocrud.model.Task;
import com.informat.trellocrud.model.enums.ListName;

import java.util.List;

public interface TaskService {
    List<Task> getAllTasks();

    List<Task> getTasksByList(ListName listname);

    Task getTaskByTaskName(String taskName);

    Task getTaskById(int id);

    Task saveOrUpdateTask(Task task);

    void deleteTask(int id);

}
