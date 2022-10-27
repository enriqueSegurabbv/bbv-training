package com.bbv.training.bbvtraining.controller;

import com.bbv.training.bbvtraining.entity.ResourceClassEntity;
import com.bbv.training.bbvtraining.service.ResourceClassService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ResourceClassController.class)
public class ResourceClassControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ResourceClassService classUnderTest;

    @Test
    public void getAllResources() throws Exception {
        when(classUnderTest.findAll())
                .thenReturn(
                        Arrays.asList(new ResourceClassEntity("Uuid", "test1"),
                                new ResourceClassEntity("Uuid2", "test2")
                        )
                );

        RequestBuilder request = MockMvcRequestBuilders
                .get("/api/resourceclass/all")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult mvcResult = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers
                        .content()
                        .string("[{\"id\":null,\"uuid\":\"Uuid\",\"name\":\"test1\"},{\"id\":null,\"uuid\":\"Uuid2\",\"name\":\"test2\"}]"))
                .andReturn();
    }


    @Test
    public void getResourceById() throws Exception {
        when(classUnderTest.findById(1L)).thenReturn(new ResourceClassEntity("Uuid", "test1"));

        RequestBuilder request = MockMvcRequestBuilders
                .get("/api/resourceclass/1")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult mvcResult = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers
                        .content()
                        .string("{\"id\":null,\"uuid\":\"Uuid\",\"name\":\"test1\"}"))
                .andReturn();
    }

    @Test
    public void deleteResourceById() throws Exception {
        when(classUnderTest.findById(1L)).thenReturn(new ResourceClassEntity("Uuid", "test1"));

        RequestBuilder request = MockMvcRequestBuilders
                .get("/delete/1")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult mvcResult = mockMvc.perform(request)
                .andExpect(status().is4xxClientError())
                .andReturn();
    }


}
