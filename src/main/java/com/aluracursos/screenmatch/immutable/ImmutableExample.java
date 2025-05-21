package com.aluracursos.screenmatch.immutable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ImmutableExample {
   public static void main(String[] args) {
      List<String> listaOriginal = new ArrayList<>();
      listaOriginal.add("A");
      listaOriginal.add("B");
      System.out.println("Elementos de la Lista ");
      for (String s : listaOriginal) {
         System.out.println(s);
      }
      List<String> listaInmutable = Collections.unmodifiableList(listaOriginal);

      // Intentar agregar un elemento a la lista inmutable resultará en una excepción
      try {
         listaInmutable.add("C"); // Lanzará UnsupportedOperationException
      } catch (UnsupportedOperationException e) {
         System.out.println("No se puede modificar lista inmutable");
      }
   }
}
