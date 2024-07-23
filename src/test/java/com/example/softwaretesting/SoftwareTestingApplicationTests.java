package com.example.softwaretesting;

import com.example.softwaretesting.entry.Student;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.nio.charset.Charset;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SoftwareTestingApplicationTests {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper jacksonObjectMapper;

    @Test
    void test() throws Exception {
        mockMvc.perform(get("/test"))
                .andExpect(result -> {
                    assertEquals(200, result.getResponse().getStatus());
                    assertEquals("Hello World", result.getResponse().getContentAsString());
                });
    }

    @Test
    void testStudent() throws Exception {
        String jsonResponse = mockMvc.perform(get("/student"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString(Charset.defaultCharset());

        System.out.println(jsonResponse);
        Student student = jacksonObjectMapper.readValue(jsonResponse, Student.class);

        // 进行断言
        assertEquals("SX2316078", student.getId());
        assertEquals("韩逸轩", student.getName());
        assertEquals("软件测试", student.getCourse());
    }
}
