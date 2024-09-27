package com.damato;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

//Pasar texto a mayusculas
public class App02 {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        File directorio = new File("adt1_practica2/src/main/resources/");
        if (directorio.exists() && directorio.isDirectory())
            Arrays.stream(directorio.listFiles()).filter(item -> item.isFile()).forEach(file -> System.out.println(file.getName()));
        else System.out.println("El directorio no existe");

        System.out.println("Escribe el texto que deseas convertir a maysuculas:");
        String entrada = sc.nextLine();


        File archivo = new File(directorio, entrada);
        if (!archivo.isFile()) {
            System.out.println("Archivo no valido");
        } else {

            System.out.println("Accediendo al archivo ubicado en " + archivo.getAbsolutePath());
            String texto = "";

            try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {

                String linea;

                while ((linea = br.readLine()) != null) {
                    texto += linea.toUpperCase() + "\n";
                }

                System.out.println("Terminado de leer el documento y convertido:\n**********************\n" + texto + "\n******************************\n");

            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
                bw.write(texto);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Texto convertixdo a mayusculas");


        }

    }


}
