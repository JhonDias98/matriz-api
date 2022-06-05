package br.com.matriz.fixture.controller;

import br.com.matriz.controller.request.MatrizRequest;

import java.util.Arrays;

public class RequestMock {

    public static MatrizRequest valida() {
        return new MatrizRequest(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
    }

    public static MatrizRequest invalida() {
        return new MatrizRequest(Arrays.asList(1, 2, 3));
    }
}
