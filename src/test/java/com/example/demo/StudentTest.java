package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.demo.student.StudentController;
import com.example.demo.student.StudentService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
public class StudentTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private StudentController controller;
    @MockBean
    private StudentService service;
    @BeforeAll
    public static void before() {
        System.out.println("[TEST] Starting StudentTest..");
    }
    @AfterAll
    public static void after() {
        System.out.println("[TEST] Ended StudentTest.");
    }
    @Test
    void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
        assertThat(service).isNotNull();
    }
    @Test
    void checkMappings() throws Exception {
        this.mockMvc.perform(get("/api/v1/student")).andDo(print()).andExpect(status().isOk());
    }
}
