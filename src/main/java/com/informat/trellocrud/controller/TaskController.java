package com.informat.trellocrud.controller;

import com.informat.trellocrud.model.Task;
import com.informat.trellocrud.model.enums.ListName;
import com.informat.trellocrud.service.implementation.TaskServiceDefault;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    @Autowired
    TaskServiceDefault taskServiceDefault;

    @GetMapping("/task")
    List<Task> getAllTasks() {
        return taskServiceDefault.getAllTasks();
    }

    @GetMapping("/task/list/{listName}")
    List<Task> getTasksByList(@PathVariable(value = "listName") ListName listName) {
        return taskServiceDefault.getTasksByList(listName);
    }

    @GetMapping("task/{id}")
    Task getTaskById(@PathVariable(value = "id") int id) {
        return taskServiceDefault.getTaskById(id);
    }

    @PostMapping("/task")
    Task saveOrUpdateTask(@RequestBody Task task) {
        return taskServiceDefault.saveOrUpdateTask(task);
    }

    @DeleteMapping("/task/{id}")
    void deleteTask(@PathVariable("id") int id) {
        taskServiceDefault.deleteTask(id);
    }

}
