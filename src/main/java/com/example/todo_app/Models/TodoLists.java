package com.example.todo_app.Models;
import org.w3c.dom.Text;

import javax.persistence.*;

@Entity
public class TodoLists {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String user;
    @Column
    private String listName;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Column
    private String listBody;

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }
    public String getListName() { return listName; }
    public void setListName(String listName) { this.listName = listName; }
    public String getlistBody() { return listBody; }
    public void setlistBody(String listBody) { this.listBody = listBody; }
}
