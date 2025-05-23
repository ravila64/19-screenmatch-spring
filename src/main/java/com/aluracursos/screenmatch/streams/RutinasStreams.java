package com.aluracursos.screenmatch.streams;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class RutinasStreams {
   public void streamInfinito() {
      Stream.iterate(0, n -> n + 1)
            .limit(10)
            .forEach(System.out::println);
   }

   public void flatMaps() {
      List<List<String>> lista = List.of(
            List.of("a", "b"),
            List.of("c", "d")
      );
      // crea stream
      Stream<String> stream = lista.stream()
            .flatMap(Collection::stream);
      //lista stream
      stream.forEach(System.out::println);
   }

   public void reduccionStreams() {
      List<Integer> numeros = List.of(1, 2, 3, 4, 5);
      Optional<Integer> resultado = numeros.stream().reduce(Integer::sum);
      resultado.ifPresent(System.out::println); // imprime 15
   }
}
