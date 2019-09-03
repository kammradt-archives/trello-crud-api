package com.informat.trellocrud.repository;


import com.informat.trellocrud.model.Task;
import com.informat.trellocrud.model.enums.ListName;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends CrudRepository<Task, Integer> {
    Task findByTaskName(String taskName);
    List<Task> findByListName(ListName listName);
}
