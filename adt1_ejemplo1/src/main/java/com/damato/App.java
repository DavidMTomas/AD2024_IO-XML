package com.damato;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class App {
    // El fichero file.txt existe en la carpeta resources?

    public static void main(String[] args) {

        String ruta = "./adt1_ejemplo1/src/main/resources/";
        File fichero = new File(ruta + "fichero.txt");

        System.out.println(fichero.getParent());

        if (fichero.exists()) {
            System.out.println("El fichero existe en la ruta " + fichero.getPath());
            System.out.println("La longitud del fichero es: " + fichero.length());
        } else {
            System.out.printf("El fichero %s no existe", fichero.getName());
            System.out.println("Desea crearlo? S o N");
            Scanner sc = new Scanner(System.in);
            do {
                String entrada = sc.nextLine().toLowerCase();
                if (entrada.equals("s")) {
                    try {
                        System.out.println(fichero.createNewFile() ? "Archivo creado con exito" : "El archivo ya existe");
                        break;
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                } else if (entrada.equals("n")) {
                    System.out.println("El archivo no sera creado");
                    break;
                } else System.out.printf("Valor %s no vlaido \nIntroduce \"S\" o \"N\"", entrada);
            } while (true);
        }
    }
}
