package br.com.matriz.service;

import br.com.matriz.config.exception.MatrizInvalidaException;
import br.com.matriz.fixture.service.ListaMock;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class MatrizServiceTest {

    @InjectMocks
    private MatrizService service;

    @Test
    void deveRetornarUmaListaRotacionadaQuandoAListaForValida() {
        var resp = service.matriz(ListaMock.valida());

        assertTrue(resp.isValido());
        assertEquals(ListaMock.valida().size(), resp.getNumeros().size());
    }

    @Test
    void deveRetornarMatrizInvalidaExceptionQuandoAListaForInvalida() {
        assertThrows(MatrizInvalidaException.class, () -> service.matriz(ListaMock.invalida()));
    }

}