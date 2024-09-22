package com.damato;

import java.io.*;
import java.util.Scanner;

public class App01 {
    private static Scanner sc = new Scanner(System.in);
    private static String entrada = "";
    private static String ruta = "adt1_practica2/src/main/resources/";

    public static void main(String[] args) {
        do {
            entrada = seleccionaOpcion();
            try {
                switch (entrada) {
                    case "1":
                        leerDesdeFichero();
                        break;
                    case "2":
                        escribirEnFichero();
                        break;
                    case "3":
                        break;
                    default:
                        System.out.println("Valor no valido");
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } while (!entrada.equals("3"));

        System.out.println("Fin de App01");
    }

    private static void escribirEnFichero() throws IOException {
        System.out.println("Indica le nombre del fichero\nSi existe lo añadiremos.\nSi no existe se creara en la carpeta resources");
        File archivo = new File(ruta, sc.nextLine());
            if (archivo.createNewFile()) {
                System.out.println("Archivo nuevo creado en: " + archivo.getPath());
            } else {
                System.out.println("Archivo existe en el directorio " + archivo.getPath());
            }
        try (PrintWriter pw = new PrintWriter(new FileWriter(archivo, true))) {
            System.out.println("Escribe el texto a guardar en el archivo: ");
            pw.write(sc.nextLine().trim());
        }

    }

    private static void leerDesdeFichero() throws IOException {
        File directorio = new File(ruta);
        System.out.println("Ficheros en la carpeta resources:");

        // Si es un directorio valido, lo mostramos
        if (directorio != null && directorio.isDirectory()) {
            for (File actual : directorio.listFiles()) {
                System.out.println(actual.getName());
            }
            System.out.println("Que fichero quieres leer: \"escribir nombre\" ");
            File fichero = new File(directorio, sc.nextLine());

            // Lectura
            if (fichero.isFile()) {
                System.out.println("El contenido del fichero " + fichero.getName() + " es el siguiente: \n");
                System.out.println("___________________________________________________________________");
                try (BufferedReader br = new BufferedReader(new FileReader(fichero))) {
                    String linea;
                    while ((linea = br.readLine()) != null) {
                        System.out.println(linea);
                    }
                    System.out.println("___________________________________________________________________");
                }
            } else System.out.println("Fichero: " + fichero.getName() + " NO encontrado!!");

        }

    }

    private static String seleccionaOpcion() {
        String texto = """
                1.- Leer desde fichero.
                2.- Escribir en el fichero
                3.- Fin
                """;
        System.out.println("\n" + texto);
        return sc.nextLine();
    }
}