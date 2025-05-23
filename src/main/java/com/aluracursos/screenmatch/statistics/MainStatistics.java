package com.aluracursos.screenmatch.statistics;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;

public class MainStatistics {
   public static void main(String[] args) {
      List<Alumno> alumnos = Arrays.asList(
            new Alumno("Alice", LocalDate.of(2002, 10, 20)),
            new Alumno("Bob", LocalDate.of(1980, 8, 9)),
            new Alumno("Carlos", LocalDate.of(2001, 01, 28)),
            new Alumno("David", LocalDate.of(2003, 05, 12)),
            new Alumno("Eva", LocalDate.of(2005, 12, 03))
      );

      IntSummaryStatistics estadisticas = alumnos.stream()
            .mapToInt(Alumno::getEdad)
            .summaryStatistics();

      // Mostrando las estadísticas
      System.out.println("Edad promedio: " + estadisticas.getAverage());
      System.out.println("Edad mínima: " + estadisticas.getMin());
      System.out.println("Edad máxima: " + estadisticas.getMax());
      System.out.println("Total de alumnos: " + estadisticas.getCount());
   }
}
