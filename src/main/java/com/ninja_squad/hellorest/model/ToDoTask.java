package com.ninja_squad.hellorest.model;

public class ToDoTask {

    public String label;
    public Priority priority;
    public static long myId = 0;
    public long id;

    public ToDoTask() {
        this.id = ++myId;
        this.priority = Priority.DEFAULT;
        this.label = "Default";
    }

    public ToDoTask(String label) {
        this();
        this.label = label;
    }
}