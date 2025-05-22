package com.aluracursos.screenmatch.typegenerics;

public class MainMethodGeneric {

   public static void main(String[] args) {
   // Caja de Integer
   Caja<Integer> cajaEnteros = new Caja<>(10);
   Integer resultadoEntero = cajaEnteros.sumaContenidoEnCaja(5);
   System.out.println("Resultado Integer: "+resultadoEntero); // 15

   // Caja de Double
   Caja<Double> cajaDoubles = new Caja<>(12.5);
   Double resultadoDouble = cajaDoubles.sumaContenidoEnCaja(3.5);
   System.out.println("Resultado Double: "+resultadoDouble); // 16.0

   // Caja de String
   Caja<String> cajaTextos = new Caja<>("Hola");
   String resultadoTexto = cajaTextos.sumaContenidoEnCaja("Mundo");
   System.out.print("Resultado String: "+resultadoTexto); // Hola\nMundo

   // Caso no compatible (ejemplo de excepción)
   // Caja<Integer> cajaError = new Caja<>(10);
   // cajaError.sumaContenidoEnCaja((Integer) null); // Esto devolverá null o lanza error si se quita el control
   }
}
