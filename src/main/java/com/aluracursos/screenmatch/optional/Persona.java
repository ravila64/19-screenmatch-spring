package com.aluracursos.screenmatch.optional;

import java.util.Optional;

public class Persona {
   private String codigo;
   private String nombre;

   public String getCodigo() {
      return codigo;
   }
   // example with Optional
   public Optional<String> getNombre() {
      // El nombre puede ser null
      return Optional.ofNullable(nombre);
   }

   public void setNombre(String nombre) {
      this.nombre = nombre;
   }
}
