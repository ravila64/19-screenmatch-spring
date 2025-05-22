package com.aluracursos.screenmatch.main;

import com.aluracursos.screenmatch.model.DatosEpisodio;
import com.aluracursos.screenmatch.model.DatosSerie;
import com.aluracursos.screenmatch.model.DatosTemporada;
import com.aluracursos.screenmatch.model.Episodio;
import com.aluracursos.screenmatch.service.ConsumoAPI;
import com.aluracursos.screenmatch.service.ConvierteDatos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class MainMenu {
   private final String URL_BASE = "https://www.omdbapi.com/?t=";
   private final String API_KEY = "&apikey=" + System.getenv("API_KEY_MOVIES");
   private Scanner teclado = new Scanner(System.in);
   private ConsumoAPI consumoApi = new ConsumoAPI();
   private ConvierteDatos conversor = new ConvierteDatos();

   public void muestraMenu() {
      System.out.println("Nombre de serie a buscar ");
      // busca los datos generales de las series
      var nombreSerie = teclado.nextLine().trim().replace(" ", "+");
      System.out.println("nombre serie :" + nombreSerie);
      String url = URL_BASE + nombreSerie + API_KEY;
      var json = consumoApi.obtenerDatos(url);
      DatosSerie serie = conversor.obtenerDatos(json, DatosSerie.class);
      System.out.println(serie);   // optional

      //busca los datos de todas las temporadas
      List<DatosTemporada> temporadas = new ArrayList<>();
      if (serie.totalTemporadas() == null) {
         System.out.println("Esta serie no tiene temporadas ");
         return;
      }
      // busca datos de todas las temporadas
      for (int i = 1; i <= serie.totalTemporadas(); i++) {
         url = URL_BASE + nombreSerie + "&Season=" + i + API_KEY;
         json = consumoApi.obtenerDatos(url);
         DatosTemporada datosTemporada = conversor.obtenerDatos(json, DatosTemporada.class);
         temporadas.add(datosTemporada);
      }
      temporadas.forEach(System.out::println);

      // mostrar solo el titulo de los eposodios para las temporadas
//      for (int i = 0; i < serie.totalTemporadas(); i++) {
//         List<DatosEpisodio> episodios = temporadas.get(i).episodios();
//         System.out.println("**Temporada** " + (i + 1) + " Episodios:" + episodios.size());
//         for (int j = 0; j < episodios.size(); j++) {
//            System.out.println("Titulo episodio :" + (j + 1) + " : " + episodios.get(j).titulo());
//         }
//      }
      // funciones lambda
      // lista todos los episodios, con el  numero,titulo, fecha lanzamiento, de todas las temporadas
//      temporadas.forEach(t -> t.episodios().forEach(e -> System.out.println((e.mumEpisodio() + 1) + " " + e.titulo() + " " + e.fechaLanzamiento())));

      // convertir todas las imformaciones a lista lista tipo DatosEpisodio
      List<DatosEpisodio> datosEpisodios = temporadas.stream()
            .flatMap(t -> t.episodios().stream())
            .collect(Collectors.toList()); // desea adicionar, mutable
      //.toList();  // cuando quiero inmutable, no deja agregar

      // top 5 episodios, reversed mayor a menor calificación
//      System.out.println("Top 5 episodios");
//      datosEpisodios.stream()
//            .filter(e -> !e.evaluacion().equalsIgnoreCase("N/A"))
//            .sorted(Comparator.comparing(DatosEpisodio::evaluacion).reversed())
//            .limit(5)
//            .forEach(System.out::println);

      // top 5 episodios segun cap. 4 del tema, manejando el .peek()
//      System.out.println("Top 5 episodios con peek-Ojeada");
//      datosEpisodios.stream()
//            .filter(e -> !e.evaluacion().equalsIgnoreCase("N/A"))
//            .peek(e -> System.out.println("Primer filtro [N/A] " + e))
//            .sorted(Comparator.comparing(DatosEpisodio::evaluacion).reversed())
//            .peek(e -> System.out.println("Segundo filtro ordenacion [M>m] " + e))
//            .map(e -> e.titulo().toUpperCase())
//            .peek(e -> System.out.println("Tercer filtro mayusculas (n>M) " + e))
//            .limit(5)
//            .forEach(System.out::println);

      // Convirtiendo los datos a una lista del tipo Episodio
      List<Episodio> episodios = temporadas.stream()
            .flatMap(t -> t.episodios().stream()
                  .map(d -> new Episodio(t.numero(), d)))
            .collect(Collectors.toList());

//      episodios.forEach(System.out::println);

      // busaueda de episodios a partir de un año especifico
//      System.out.println("Digite año a partir del cual deseas ver episodios :");
//      var fecha = teclado.nextInt();
//      LocalDate fechaBusqueda = LocalDate.of(fecha, 1, 1);
//      DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//      episodios.stream()
//            .filter(e->e.getFechaLanzamiento() != null &&
//                  (e.getFechaLanzamiento().isAfter(fechaBusqueda) || e.getFechaLanzamiento().isEqual(fechaBusqueda)))
//            .forEach(e -> System.out.println(
//                  "Temporada :"+e.getTemporada()+
//                        " Episodio :"+e.getTitulo()+
//                        " Fecha lanzamiento :"+e.getFechaLanzamiento().format(dtf)
//            ));
//     // 05 busca episodios por pedazo del titulo
//      System.out.println("Digite titulo episodio ");
//      var pedazoEpisodio = teclado.nextLine();
//      Optional<Episodio> episodioEncontrado = episodios.stream()
//            .filter(e -> e.getTitulo().toUpperCase().contains(pedazoEpisodio.toUpperCase()))
//            .findFirst();  // busca la primera aparicion segun condicion del filtro
//     // episodioEncontrado.ifPresent(episodio -> System.out.println("Episodio encontrado: \n" + episodio));
//      if(episodioEncontrado.isPresent()){
//         System.out.println("Episodio encontrado: \n" + episodioEncontrado.get());
//      }else{
//         System.out.println("Episodio no encontrado !!!");
//      }
      // 08 Creando un mapa de datos x temporada
      // hace una promedio de evaluacion por temporada, agrupandola
      //  Map integer=clave Double=valor
         Map<Integer, Double> evaluacionesTemporada = episodios.stream()
               .filter(e->e.getEvaluacion()>0.0)
               .collect(Collectors.groupingBy(Episodio::getTemporada,
                     Collectors.averagingDouble(Episodio::getEvaluacion)));
      // aqui tambien imprime el mapa sin formateo
      System.out.println(evaluacionesTemporada);
      // imprimir el map (clave, valor)
      for (Map.Entry<Integer, Double> entry : evaluacionesTemporada.entrySet()) {
         Integer temporada = entry.getKey(); // Obtiene la clave (número de temporada)
         Double evaluacionPromedio = entry.getValue(); // Obtiene el valor (promedio de evaluación)
         System.out.println("Temporada: " + temporada + ", Evaluación Promedio: " + evaluacionPromedio);
      }
   }
}
//
