package com.aluracursos.screenmatch;

import com.aluracursos.screenmatch.model.DatosSerie;
import com.aluracursos.screenmatch.service.ConsumoAPI;
import com.aluracursos.screenmatch.service.ConvierteDatos;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

   public static void main(String[] args) {
      SpringApplication.run(ScreenmatchApplication.class, args);
   }

   @Override
   public void run(String... args) throws Exception {
      // api
      var consumoApi = new ConsumoAPI();
      var json = "";
      //captura pelicula a buscar
      Scanner leer = new Scanner(System.in);
      String apiPeliculas = System.getenv("API_KEY_MOVIES");
      if (apiPeliculas != null && !apiPeliculas.isEmpty()) {
         System.out.println("API Key: Verified");
      } else {
         System.out.println("La variable de entorno no está definida, para este dispositivo.");
         return;
      }
      var busqueda = "";
      while (true) {
         System.out.print("Nombre pelicula a buscar [Digite 'salir' = terminar ] ");
         busqueda = leer.nextLine();
         if (busqueda.equalsIgnoreCase("salir")) {
            break;
         }
         busqueda = busqueda.replace(" ", "+"); // nombres compuestos
         String url = "https://www.omdbapi.com/?t=" + busqueda + "&apikey=" + apiPeliculas;
         //String url2 = "https://coffee.alexflipnote.dev/random.json";
         json = consumoApi.obtenerDatos(url);
         System.out.println("json "+ json);
         ConvierteDatos convierteDatos = new ConvierteDatos();
         var datos = convierteDatos.obtenerDatos(json, DatosSerie.class);
         System.out.println("datos "+datos);
      }
      ; // wend

   }
}
