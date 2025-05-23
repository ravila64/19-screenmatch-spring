package com.aluracursos.screenmatch.streams;

public class AdvancedStreams {
   public static void main(String[] args) {
      RutinasStreams rs = new RutinasStreams();
      System.out.println("Resultado stream infinito");
      rs.streamInfinito();
      System.out.println("Resultado flatMap");
      rs.flatMaps();
      System.out.println("Resultado reduccion streams");
      rs.reduccionStreams();
   }
}
