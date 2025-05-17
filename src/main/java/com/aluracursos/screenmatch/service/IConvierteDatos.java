package com.aluracursos.screenmatch.service;

public interface IConvierteDatos {
   // definir tipos de datos GENERICOS
   <T> T obtenerDatos(String json, Class <T> clase);
}
