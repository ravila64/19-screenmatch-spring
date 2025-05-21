package com.aluracursos.screenmatch.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ExampleStreamString {
    public static void main(String[] args) {
        List<String> palabras = Arrays.asList("Java", "Stream", "Operaciones", "Intermedias");
        List<Integer> tamanos = palabras.stream()
                .map(s -> s.length())
                .collect(Collectors.toList());
        System.out.println(tamanos); // Salida: [4, 6, 11, 11]

        List<String> nombres = Arrays.asList("Juan", "Maria", "Pedro", "Ana");
        nombres.stream()
              .forEach(nombre -> System.out.println("Hola, " + nombre + "!"));
    }
}
