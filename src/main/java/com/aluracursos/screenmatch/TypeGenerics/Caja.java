package com.aluracursos.screenmatch.TypeGenerics;

public class Caja<T> {
   private T contenido;

   public Caja(T contenido) {
      this.contenido = contenido;
   }

   public T getContenido() {
      return contenido;
   }

   public void setContenido(T contenido) {
      this.contenido = contenido;
   }

   @Override
   public String toString() {
      return "Caja{" +
            "contenido=" + contenido +
            '}';
   }
   
   @SuppressWarnings("unchecked")
   public T sumaContenidoEnCaja(T valor) {

      if (contenido == null || valor == null) return null;
      if (contenido instanceof Integer c && valor instanceof Integer i) {
         return (T) Integer.valueOf(c + i);
      } else if (contenido instanceof Double c && valor instanceof Double d) {
         return (T) Double.valueOf(c + d);
      } else if (contenido instanceof String c && valor instanceof String s) {
         return (T) (c + "\n" + s);
      } else {
         throw new IllegalArgumentException("Tipo no compatible: " +
               contenido.getClass() + " y " + valor.getClass());
      }
   }
}
