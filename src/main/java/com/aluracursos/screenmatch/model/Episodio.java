package com.aluracursos.screenmatch.model;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Episodio {
   private Integer temporada;
   private String titulo;
   private Integer numEpisodio;
   private Double evaluacion;
   private LocalDate fechaLanzamiento;

   public Episodio(Integer numero, DatosEpisodio d) {
      this.temporada = numero;
      this.titulo = d.titulo();
      this.numEpisodio = d.mumEpisodio();
      try {
         this.evaluacion = Double.valueOf(d.evaluacion()); //String a Double
      } catch (NumberFormatException e) {
         this.evaluacion = 0.0;
      }
      try{
         this.fechaLanzamiento = LocalDate.parse(d.fechaLanzamiento()); //  String a Fecha
      } catch (DateTimeParseException e){
         this.fechaLanzamiento = null;
      }
   }
   // getters and setters

   public Double getEvaluacion() {
      return evaluacion;
   }

   public void setEvaluacion(Double evaluacion) {
      this.evaluacion = evaluacion;
   }

   public LocalDate getFechaLanzamiento() {
      return fechaLanzamiento;
   }

   public void setFechaLanzamiento(LocalDate fechaLanzamiento) {
      this.fechaLanzamiento = fechaLanzamiento;
   }

   public Integer getNumEpisodio() {
      return numEpisodio;
   }

   public void setNumEpisodio(Integer numEpisodio) {
      this.numEpisodio = numEpisodio;
   }

   public Integer getTemporada() {
      return temporada;
   }

   public void setTemporada(Integer temporada) {
      this.temporada = temporada;
   }

   public String getTitulo() {
      return titulo;
   }

   public void setTitulo(String titulo) {
      this.titulo = titulo;
   }

   @Override
   public String toString() {
      return "Ep{" +
            "evaluacion=" + evaluacion +
            ", temporada=" + temporada +
            ", titulo='" + titulo + '\'' +
            ", numEpisodio=" + numEpisodio +
            ", fechaLanzamiento=" + fechaLanzamiento +
            '}';
   }
}
