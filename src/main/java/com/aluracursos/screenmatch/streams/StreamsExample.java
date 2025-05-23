package com.aluracursos.screenmatch.streams;

import java.util.Arrays;
import java.util.List;

public class StreamsExample {
    public void muestraEjemplo(){
        List<String> nombres = Arrays.asList("Brenda","Luis","Camila","Beatriz","Ana","Eric","Genesys");
        nombres.stream()
                .sorted()
                .limit(4)
                //.filter(n->n.startsWith("C"))
                .map(n->n.toUpperCase())
                .forEach(System.out::println);
    }
}
