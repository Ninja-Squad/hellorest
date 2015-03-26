package com.ninja_squad.hellorest.controller;

import com.ninja_squad.hellorest.model.*;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
public class ToDoController {

    // We use a simple in memory list (don't do it in real life!)
    private final List<ToDoTask> tasks = new ArrayList<>();

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public ToDoTask add(@RequestBody ToDoTask task) {
        tasks.add(task);
        return task;
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ToDoTask> edit(@PathVariable("id") long id, @RequestBody ToDoTask task) {

        ToDoTask foundTask = this.getTaskById(id).getBody();
        if (task != null) {
            foundTask.label = task.label;
            foundTask.priority = task.priority;
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(task, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ToDoTask> remove(@PathVariable("id") long id) {

        ToDoTask task = this.getTaskById(id).getBody();
        if (task != null) {
            tasks.remove(task);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(task, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ToDoTask> getTaskById(@PathVariable("id") long id) {

        for (ToDoTask task : tasks) {
            if (task.id == id) {
                return new ResponseEntity(task, HttpStatus.OK);
            }
        }

        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<ToDoTask> list() {
        return tasks;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/priorities")
    @ResponseStatus(HttpStatus.OK)
    public Priority[] priorities() {
        return Priority.values();
    }

    // TODO Add a GET method listing existing tasks
}
