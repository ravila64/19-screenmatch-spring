package com.aluracursos.screenmatch.typegenerics;

public class TesteaCaja {
   public static void main(String[] args) {
      Caja<String> cajaDeTexto = new Caja("Hola mundo");
      System.out.println("Primer valor guardado "+cajaDeTexto);
      cajaDeTexto.setContenido("Guardando texto en mi caja!");
      System.out.println("2do valor guardado:"+cajaDeTexto);

      Caja<Integer> cajaDeEdad = new Caja(61);
      System.out.println("Primer valor guardado "+cajaDeEdad);
      cajaDeEdad.setContenido(30);
      System.out.println("2do valor guardado:"+cajaDeEdad);

      Caja<Double> cajaDeValor = new Caja<>(125.5);
      System.out.println("Primer valor guardado "+cajaDeValor);
      cajaDeValor.setContenido(150.50);
      System.out.println("2do valor guardado:"+cajaDeValor);
   }
}
