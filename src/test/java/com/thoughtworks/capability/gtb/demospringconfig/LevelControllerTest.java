package com.thoughtworks.capability.gtb.demospringconfig;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
class LevelControllerTest1 {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private LevelController levelController;
    @Test
    public void shouldGetBasicLevelWhenLevelNumberIsLessOne() throws Exception {
        String  result=mockMvc.perform(get("/level")).andReturn().getResponse().getContentAsString();
        assertEquals(result, "basic");
    }
}

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(properties={"levelNumber=1"})
class LevelControllerTest2 {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private LevelController levelController;
    @Test
    public void shouldGetBasicLevelWhenLevelNumberIsLessOne() throws Exception {
        String  result=mockMvc.perform(get("/level")).andReturn().getResponse().getContentAsString();
        assertEquals(result, "advanced");
    }
}

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(properties={"levelNumber=3"})
class LevelControllerTests3{
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private LevelController levelController;

    @Test
    public void shouldGetBasicLevelWhenLevelNumberIsGreaterOne() throws Exception {
        String  result=mockMvc.perform(get("/level")).andReturn().getResponse().getContentAsString();
        assertEquals(result, "advanced");
    }
}