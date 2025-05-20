package com.aluracursos.screenmatch.lambda;

import java.util.Arrays;
import java.util.List;

public class FuncionLambda {
   public static void main(String[] args) {
      List<Integer> lista = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
      lista.stream().filter(i -> i % 2 == 0).forEach(System.out::println);
   }
}
