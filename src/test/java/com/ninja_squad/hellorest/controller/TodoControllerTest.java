package com.ninja_squad.hellorest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ninja_squad.hellorest.AppConfig;
import com.ninja_squad.hellorest.WebConfig;
import com.ninja_squad.hellorest.model.Priority;
import com.ninja_squad.hellorest.model.ToDoTask;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {AppConfig.class, WebConfig.class})
public class TodoControllerTest {

    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Before
    public void setup() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void addTask() throws Exception {

        ToDoTask task = new ToDoTask("test");
        task.priority = Priority.HIGH;

        mockMvc.perform(post("/tasks").content(objectMapper.writeValueAsBytes(task))
                .contentType(MediaType.APPLICATION_JSON))
               .andExpect(status().isCreated())
                .andExpect(jsonPath("$.priority").value(Priority.HIGH.name()))
                .andExpect(jsonPath("$.label").value("test"));
    }

    @Test
    public void listTasks() throws Exception {

        mockMvc.perform(get("/tasks"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }


}
