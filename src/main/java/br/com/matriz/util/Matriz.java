package br.com.matriz.util;

import java.util.List;

public class Matriz {

    public static Integer getDimensao(List<Integer> numeros) {
        return (int) Math.sqrt(numeros.size());
    }

    public static boolean isValida(List<Integer> numeros) {
        if(numeros.size() == Math.sqrt(numeros.size()) * Math.sqrt(numeros.size())) {
            return true;
        }
        return false;
    }

}
