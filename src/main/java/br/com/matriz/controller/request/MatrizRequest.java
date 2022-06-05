package br.com.matriz.controller.request;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@Schema
public class MatrizRequest {
    @Schema(description = "Lista de números interios")
    private List<Integer> numeros;

    public MatrizRequest() {
    }

    public MatrizRequest(List<Integer> numeros) {
        this.numeros = numeros;
    }

    public List<Integer> getNumeros() {
        return numeros;
    }
}
