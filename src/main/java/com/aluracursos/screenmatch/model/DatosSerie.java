package com.aluracursos.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
// @JsonAlias = leer  @JsonProperty() = escribir
public record DatosSerie(
      @JsonAlias("Title") String titulo,
      @JsonAlias("totalSeasons") Integer totalTemporadas,
      @JsonAlias("imdbRating") String evaluacion) {
}
