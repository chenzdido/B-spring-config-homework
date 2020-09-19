package com.thoughtworks.capability.gtb.demospringconfig;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.omg.CORBA.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
class LevelControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private LevelController levelController;


    @Test
    public void shouldGetBasicLevelWhenLevelNumberIsLessOne() throws Exception {
        String  result=mockMvc.perform(get("/level")).andReturn().getResponse().getContentAsString();
        assertEquals(result, "basic");
    }

    @Test
    public void shouldGetBasicLevelWhenLevelNumberIsOne() throws Exception {
        ReflectionTestUtils.setField(levelController, "levelNumber", 1);
        String  result=mockMvc.perform(get("/level")).andReturn().getResponse().getContentAsString();
        assertEquals(result, "advanced");
    }

    @Test
    public void shouldGetBasicLevelWhenLevelNumberIsGreaterOne() throws Exception {
        ReflectionTestUtils.setField(levelController, "levelNumber", 3);
        String  result=mockMvc.perform(get("/level")).andReturn().getResponse().getContentAsString();
        assertEquals(result, "advanced");
    }

}