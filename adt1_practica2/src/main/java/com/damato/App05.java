package com.damato;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

//buscar palabra
public class App05 {
    private static Scanner sc = new Scanner(System.in);
    private static File archivo;

    public static void main(String[] args) throws FileNotFoundException {
        String ruta = "adt1_practica2/src/main/resources/";
        archivo = new File(ruta, "texto1Copy.txt");


        System.out.println("Escribe la palabra a buscar:");
        String entrada = sc.nextLine();
        encontrarPalabra(entrada);


    }

    private static void encontrarPalabra(String entrada) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {

            String linea;
            int numeroLinea = 0;
            while ((linea = br.readLine()) != null) {
                numeroLinea++;
                String[] palabras = linea.split("\\s+");
                if (Arrays.stream(palabras).anyMatch(i -> (" " + i + " ").contains(" " + entrada + " "))) {
                    System.out.printf("Palabra '%s' encontrada en la línea %d\n", entrada, numeroLinea);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
