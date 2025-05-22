package com.aluracursos.screenmatch.optional;

import java.util.Optional;

public class OptionalExample {
   public static void main(String[] args) {
      Persona persona = new Persona();
      persona.setNombre("Ana Rosa");
      // Llamar al método getNombre
      Optional<String> optionalNombre = persona.getNombre();
      // Imprimir el nombre si está presente
      optionalNombre.ifPresent(System.out::println);
      // Devolverá "Nombre no disponible" si nombre es null
      String nombre = optionalNombre.orElse("Nombre no disponible");
      // Imprimirá el nombre solo si no es null
   }
}
