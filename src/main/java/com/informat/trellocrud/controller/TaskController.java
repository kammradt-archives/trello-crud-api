package com.informat.trellocrud.controller;

import com.informat.trellocrud.model.Task;
import com.informat.trellocrud.model.enums.ListName;
import com.informat.trellocrud.service.implementation.TaskServiceDefault;
import com.informat.trellocrud.service.implementation.TrelloApiDefault;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class TaskController {

    @Autowired
    TaskServiceDefault taskServiceDefault;

    @Autowired
    TrelloApiDefault trelloApiDefault;

    @GetMapping("/task")
    List<Task> getAllTasks() {
        return taskServiceDefault.getAllTasks();
    }

    @GetMapping("/task/list")
    List<Task> getTasksByList(@RequestParam("listName") ListName listName) {
        return taskServiceDefault.getTasksByList(listName);
    }

    @GetMapping("/task/search")
    Task getTaskByTaskName(@RequestParam("taskName") String taskName) {
        return taskServiceDefault.getTaskByTaskName(taskName);
    }

    @GetMapping("task/{id}")
    Task getTaskById(@PathVariable(value = "id") int id) {
        return taskServiceDefault.getTaskById(id);
    }

    @PostMapping("/task")
    Task saveOrUpdateTask(@RequestBody Task task) {
        Task taskCreated = trelloApiDefault.sendTaskToTrello(task);
        return taskServiceDefault.saveOrUpdateTask(taskCreated);
    }

    @DeleteMapping("/task/{id}")
    void deleteTask(@PathVariable("id") int id) {
        taskServiceDefault.deleteTask(id);
    }

}
