package br.com.matriz.service;

import br.com.matriz.config.exception.MatrizInvalidaException;
import br.com.matriz.controller.response.MatrizResponse;
import static br.com.matriz.util.Matriz.getDimensao;
import static br.com.matriz.util.Matriz.isValida;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MatrizService {

    Integer dimensaoMatriz;

    public MatrizResponse matriz(List<Integer> numeros) {
        if (isValida(numeros) && !numeros.isEmpty()) {
            dimensaoMatriz = getDimensao(numeros);
            int [][] matriz = converterListaParaMatriz(numeros);

            matriz = rotacionar(dimensaoMatriz, dimensaoMatriz, matriz);

            return new MatrizResponse(true, converterMatrizParaLista(matriz));
        }
        throw new MatrizInvalidaException("Lista não compatível com uma matriz quadrada");
    }

    private int[][] rotacionar(int dimensaoLinha, int dimensaoColuna, int matriz[][])
    {
        int indexLinhaInicial = 0, indexColunaInicial = 0;
        int indexAnterior, indexAtual;

        while (indexLinhaInicial < dimensaoLinha && indexColunaInicial < dimensaoColuna) {

            if (indexLinhaInicial + 1 == dimensaoLinha || indexColunaInicial + 1 == dimensaoColuna)
                break;

            indexAnterior = matriz[indexLinhaInicial + 1][indexColunaInicial];

            for (int i = indexColunaInicial; i < dimensaoColuna; i++) {
                indexAtual = matriz[indexLinhaInicial][i];
                matriz[indexLinhaInicial][i] = indexAnterior;
                indexAnterior = indexAtual;
            }
            indexLinhaInicial++;

            for (int i = indexLinhaInicial; i < dimensaoLinha; i++) {
                indexAtual = matriz[i][dimensaoColuna - 1];
                matriz[i][dimensaoColuna - 1] = indexAnterior;
                indexAnterior = indexAtual;
            }
            dimensaoColuna--;

            if (indexLinhaInicial < dimensaoLinha) {
                for (int i = dimensaoColuna - 1; i >= indexColunaInicial; i--) {
                    indexAtual = matriz[dimensaoLinha - 1][i];
                    matriz[dimensaoLinha - 1][i] = indexAnterior;
                    indexAnterior = indexAtual;
                }
            }
            dimensaoLinha--;

            if (indexColunaInicial < dimensaoColuna) {
                for (int i = dimensaoLinha - 1; i >= indexLinhaInicial; i--) {
                    indexAtual = matriz[i][indexColunaInicial];
                    matriz[i][indexColunaInicial] = indexAnterior;
                    indexAnterior = indexAtual;
                }
            }
            indexColunaInicial++;
        }
        return matriz;
    }

    private int[][] converterListaParaMatriz (List<Integer> numeros) {
        int[][] matriz = new int[dimensaoMatriz][dimensaoMatriz];
        int indexList = 0;

        for (int x = 0; x < dimensaoMatriz; x++) {
            for (int y = 0; y < dimensaoMatriz; y++) {
                matriz[x][y] = numeros.get(indexList);
                indexList++;
            }
        }
        return matriz;
    }

    private List<Integer> converterMatrizParaLista (int[][] matriz) {
        List<Integer> numeros = new ArrayList<>();

        for (int x = 0; x < dimensaoMatriz; x++) {
            for (int y = 0; y < dimensaoMatriz; y++) {
                numeros.add(matriz[x][y]);
            }
        }
        return numeros;
    }

}
