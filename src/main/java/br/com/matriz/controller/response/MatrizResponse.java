package br.com.matriz.controller.response;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.ArrayList;
import java.util.List;

@Schema
public class MatrizResponse {

    @Schema(description = "Retorna se a lista é válida ou não")
    private boolean valido;
    @Schema(description = "Caso a lista for válida, retorna a lista rotacionada, caso contrário, retorna a lista vazia")
    private List<Integer> numeros = new ArrayList<>();

    public MatrizResponse() {
    }

    public MatrizResponse(boolean valido, List<Integer> numeros) {
        this.valido = valido;
        this.numeros = numeros;
    }

    public boolean isValido() {
        return valido;
    }

    public List<Integer> getNumeros() {
        return numeros;
    }
}
