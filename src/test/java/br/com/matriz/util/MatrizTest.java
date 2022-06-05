package br.com.matriz.util;

import br.com.matriz.fixture.service.ListaMock;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class MatrizTest {

    @Test
    void deveRetornarDimensaoDaMatriz() {
        var resp = Matriz.getDimensao(ListaMock.valida());

        assertEquals((int)Math.sqrt(ListaMock.valida().size()), resp);
    }

    @Test
    void deveRetornarTrueQuandoAListaFormarUmaMatrizQuadrada() {
        assertTrue(Matriz.isValida(ListaMock.valida()));
    }

    @Test
    void deveRetornarFalseQuandoAListaNaoFormarUmaMatrizQuadrada() {
        assertFalse(Matriz.isValida(ListaMock.invalida()));
    }

}