package com.aluracursos.screenmatch.main;

import com.aluracursos.screenmatch.service.ConsumoAPI;

import java.net.URL;
import java.util.Scanner;

public class Main {
    private Scanner teclado = new Scanner(System.in);
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    //String apiPeliculas = System.getenv("API_KEY_MOVIES");
    private final String URL_BASE = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=" + System.getenv("API_KEY_MOVIES");

    public void muestraMenu() {
        System.out.println("Nombre de serie a buscar ");
        var nombreSerie = teclado.nextLine();
        nombreSerie = nombreSerie.replace(" ", "+"); // nombres compuestos
        String url = URL_BASE + nombreSerie + API_KEY;
    }

}
