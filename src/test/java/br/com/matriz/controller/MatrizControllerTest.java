package br.com.matriz.controller;

import br.com.matriz.controller.request.MatrizRequest;
import br.com.matriz.fixture.controller.RequestMock;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class MatrizControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private MatrizRequest requestValida;
    private MatrizRequest requestInvalida;

    @BeforeEach
    void setUp() {
        requestValida = RequestMock.valida();
        requestInvalida = RequestMock.invalida();
    }

    @Test
    void deveRetornarStatus200QuandoAListaForValida() throws Exception {
        String jsonBody = objectMapper.writeValueAsString(requestValida);

        mockMvc.perform(MockMvcRequestBuilders
                .put("/matriz")
                .content(jsonBody)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.valido").value(true))
                .andExpect(MockMvcResultMatchers.jsonPath("$.numeros").exists());
    }

    @Test
    void deveRetornarStatus400QuandoAListaForValida() throws Exception {
        String jsonBody = objectMapper.writeValueAsString(requestInvalida);

        mockMvc.perform(MockMvcRequestBuilders
                .put("/matriz")
                .content(jsonBody)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.valido").value(false))
                .andExpect(MockMvcResultMatchers.jsonPath("$.numeros").exists());
    }
}