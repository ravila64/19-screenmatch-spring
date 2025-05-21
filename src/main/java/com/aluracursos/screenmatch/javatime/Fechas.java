package com.aluracursos.screenmatch.javatime;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Fechas {
   public static void main(String[] args) {
      String patron = "E, dd MMM yyyy HH:mm:ss z";
      SimpleDateFormat formatoFecha = new SimpleDateFormat(patron);
      String fecha = formatoFecha.format(new Date());
      System.out.println(fecha);
      // salida: mié, 21 may 2025 12:06:19 GMT-05:00
   }
}
