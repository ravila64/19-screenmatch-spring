package com.aluracursos.screenmatch.statistics;

import java.time.LocalDate;
import java.time.Period;

public class Alumno {
   private String nombre;
   private LocalDate fechaNacimiento;

   public Alumno(String nombre, LocalDate fechaNacimiento) {
      this.nombre = nombre;
      this.fechaNacimiento = fechaNacimiento;
   }

   public int getEdad() {
      Period periodo = Period.between(fechaNacimiento, LocalDate.now());
      return periodo.getYears();
   }

   // getters, setters y toString omitidos
}
