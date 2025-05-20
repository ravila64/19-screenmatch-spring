package com.aluracursos.screenmatch.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ExampleStreamNumber {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> numerosPares = numeros.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());

        System.out.println(numerosPares); // Salida: [2, 4, 6, 8, 10]
    }
}
