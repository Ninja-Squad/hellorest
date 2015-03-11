package com.ninja_squad.hellorest.controller;

import com.ninja_squad.hellorest.model.ToDoTask;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class ToDoController {

    private final List<ToDoTask> tasks = new ArrayList<>();

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public ToDoTask add(@RequestBody ToDoTask task) {
        tasks.add(task);
        return task;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<ToDoTask> list() {
        return tasks;
    }

}
