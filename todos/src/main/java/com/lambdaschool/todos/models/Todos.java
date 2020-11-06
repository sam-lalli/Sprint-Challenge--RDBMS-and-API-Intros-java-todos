package com.lambdaschool.todos.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "todos")
public class Todos extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long todoid;

    @Column(nullable = false)
    private String description;

    private boolean completed;

    @ManyToOne
    @JoinColumn(name = "userid", nullable = false)
    @JsonIgnoreProperties(value = "todos", allowSetters = true)
    private User users;

    public Todos() {
    }

    public Todos(String description, boolean completed) {
        this.description = description;
        this.completed = completed;
    }

    public long getTodoid() {
        return todoid;
    }

    public void setTodoid(long todoid) {
        this.todoid = todoid;
    }

    public String getDescription() {
            if (description == null)
            {
                return null;
            } else
            {
                return description;
            }
        }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public User getUsers() {
        if (users == null)
        {
            return null;
        } else
        {
            return users;
        }
    }

    public void setUsers(User users) {
        this.users = users;
    }

    //    todoid primary key, not null long
//    description string, not null
//    completed boolean. Note that for all new todos, default completed to false
//    userid foreign key (one user to many todos) not null
//    All tables must have the standard 4 auditing fields in place and working, being populated: created on, created by, last modified on, last modified by. The auditing usernames will all default to llama.
//    USERS have a one to many relationship with TODOS.
}

