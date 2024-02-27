package me.mryakar.approach.mapstructignorefieldsexplicitly.rest;


import me.mryakar.approach.mapstructignorefieldsexplicitly.dto.PersonModel;
import me.mryakar.approach.mapstructignorefieldsexplicitly.service.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.OffsetDateTime;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PersonRestController.class)
class TestPersonRestController {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PersonService service;

    @Test
    void Should_ReadAllPersons() throws Exception {
        List<PersonModel> personDtoList = List.of(new PersonModel(
                1L,
                OffsetDateTime.now(),
                OffsetDateTime.now(),
                "name",
                "surname",
                1
        ));
        when(service.read()).thenReturn(personDtoList);

        mockMvc.perform(get("/person"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$.[0].id").value(1L))
                .andExpect(jsonPath("$.[0].firstName").value("name"))
                .andExpect(jsonPath("$.[0].lastName").value("surname"))
                .andExpect(jsonPath("$.[0].age").value(1))
                .andExpect(jsonPath("$.[0].createdDate").doesNotExist())
                .andExpect(jsonPath("$.[0].lastModifiedDate").doesNotExist());
        verify(service).read();
    }
}