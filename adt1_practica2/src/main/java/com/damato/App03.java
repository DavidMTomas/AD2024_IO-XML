package com.damato;

import java.io.*;

// Contar numero de vocales y numero de palabras
public class App03 {
    public static void main(String[] args) {
        File archivo = new File("adt1_practica2/src/main/resources/contarVocalesYPalabras.txt");

        int numeroPalabras = 0;
        int numeroVocales = 0;

        try {
            crearFichero(archivo);

            BufferedReader br = new BufferedReader(new FileReader(archivo));
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] palabras = linea.split("\\s+");
                numeroPalabras += palabras.length;

                for (String actual : palabras) {
                    for (Character letra : actual.toLowerCase().toCharArray()) {
                        if (letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u')
                            numeroVocales++;
                    }
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        System.out.printf("El texto %s, tiene %d palabras y %d vocales", archivo.getName(), numeroPalabras, numeroVocales);

    }


    private static void crearFichero(File archivo) throws IOException {
        //Son practicas de estudiante y solo pretendo usar metodos de la clase File
        if (archivo.exists() && archivo.length() > 0) {
            System.out.println("El archiv oexiste y tiene contenido");
            return;
        }
        if (archivo.createNewFile()) {
            System.out.println("Archvio nuevo creado");
        } else {
            BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
            bw.write("HOla como va la tarde? Todo bien   Yo tambien.");
            bw.close();
            System.out.println("Texto introducido en el fichero");
        }
    }
}
