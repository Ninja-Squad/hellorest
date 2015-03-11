package com.ninja_squad.hellorest.model;

public class ToDoTask {

    private Priority priority = Priority.DEFAULT;

    private String label;

    public ToDoTask() {
    }

    public ToDoTask(String label) {
        this.label = label;
    }

    public ToDoTask(Priority priority, String label) {
        this.priority = priority;
        this.label = label;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
