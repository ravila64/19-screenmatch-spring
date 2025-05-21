package com.aluracursos.screenmatch.javatime;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FormateandoFechas {
   public static void main(String[] args) {
      LocalDateTime hoy = LocalDateTime.now();
      System.out.println(hoy);
      DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");
      LocalDateTime ahora = LocalDateTime.now();
      System.out.println(hoy.format(formateador));
      // salida generada :
      // 2025-05-21T12:15:14.355184400
      // 21/05/2025 12:15:14
   }
}
