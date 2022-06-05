package br.com.matriz.fixture.service;

import java.util.Arrays;
import java.util.List;

public class ListaMock {

    public static List<Integer> valida() {
        return Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
    }

    public static List<Integer> invalida() {
        return Arrays.asList(1, 2, 3);
    }
}
