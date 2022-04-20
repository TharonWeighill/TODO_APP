package com.example.todo_app.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TodoLists {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public String getListItem() {
        return listItem;
    }

    public long getId() {
        return id;
    }

    private String listItem;

    public void setListItem(String listItem) {
        this.listItem = listItem;
    }

    public void setId(long id) {
        this.id = id;
    }
}
