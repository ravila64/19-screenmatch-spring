package com.aluracursos.screenmatch.streams;

public class ExampleStreamString {
    public static void main(String[] args) {
        List<String> palabras = Arrays.asList("Java", "Stream", "Operaciones", "Intermedias");
        List<Integer> tamaños = palabras.stream()
                .map(s -> s.length())
                .collect(Collectors.toList());

        System.out.println(tamaños); // Salida: [4, 6, 11, 11]
    }
}
