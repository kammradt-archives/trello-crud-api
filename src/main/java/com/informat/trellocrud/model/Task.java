package com.informat.trellocrud.model;

import com.informat.trellocrud.model.enums.ListName;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Task {
    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String trelloId;

    @Column(nullable = false, unique = true)
    private String taskName;

    @Column(nullable = false)
    private ListName listName;

    @Column(nullable = false)
    private Date createdAt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTrelloId() {
        return trelloId;
    }

    public void setTrelloId(String trelloId) {
        this.trelloId = trelloId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public ListName getListName() {
        return listName;
    }

    public void setListName(ListName listName) {
        this.listName = listName;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
