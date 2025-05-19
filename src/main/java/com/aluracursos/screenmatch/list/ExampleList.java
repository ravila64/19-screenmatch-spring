package com.aluracursos.screenmatch.list;

import java.util.ArrayList;
import java.util.List;

public class ExampleList {
    public static void main(String[] args) {
        // Creando un objeto del tipo List para almacenar números enteros
        List<Integer> numeros = new ArrayList<>();

        // Agregando elementos a la lista
        numeros.add(10);
        numeros.add(20);
        numeros.add(30);

        // Accediendo a elementos de la lista
        System.out.println("Primer elemento: " + numeros.get(0)); // Salida: 10
        System.out.println("Segundo elemento: " + numeros.get(1)); // Salida: 20
        System.out.println("Tercer elemento: " + numeros.get(2)); // Salida: 30

        // Recorriendo los elementos de la lista
        for (Integer numero : numeros) {
            System.out.println(numero);
        }

        // Eliminando un elemento de la lista
        numeros.remove(1); // Elimina el elemento en el índice 1 (20)

        // Verificando el tamaño de la lista
        System.out.println("Tamaño de la lista: " + numeros.size()); // Salida: 2
    }

}
