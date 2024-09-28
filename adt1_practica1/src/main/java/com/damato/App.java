package com.damato;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    //Realiza un proyecto Java denominado adt1_practica1 que trabaje con la clase File.
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        GestionArchivos gestionArchivos = new GestionArchivos("", "", "");
        int entrada = 0;

        do {
            menu();
            while (true) {
                try {
                    entrada = sc.nextInt();
                    sc.nextLine();
                    if (entrada < 1 || entrada > 7) {
                        System.out.println("Introducir un valor entre 1 y 7 ");
                    } else {
                        opciones(gestionArchivos, entrada, sc);
                        break;
                    }

                } catch (InputMismatchException e) {
                    sc.nextLine();
                    System.out.println("El valor debe ser numérico entre 1 y 7");
                }
            }

        } while (entrada != 7);
        System.out.println("Fin del proyecto");


    }

    private static void opciones(GestionArchivos gestionArchivos, int entrada, Scanner sc) {
        switch (entrada) {
            case 1:
                gestionArchivos.asignarRutaTrabajo(sc);
                break;
            case 2:
                gestionArchivos.listarRuta();
                break;
            case 3:
                gestionArchivos.informacioDetalladaArchivo(sc);
                break;
            case 4:
                gestionArchivos.crearCarpeta(sc);
                break;
            case 5:
                gestionArchivos.crearFichero(sc);
                break;
            case 6:
                gestionArchivos.eliminarFichero(sc);
                break;
            case 7:
                break;
            default:
                System.out.println("Valor no encontrado");

        }
    }

    private static void menu() {
        String texto = """
                ----- Elige una opción: -----
                1.- Asignar ruta de trabajo.
                2.- Listado de la ruta de trabajo.
                3.- Información detallada del archivo.
                4.- Creación de un directorio.
                5.- Creación de un fichero.
                6.- Eliminación de un fichero.
                7.- Salir.
                """;
        System.out.println("\n" + texto);
    }
}