package com.damato;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class App {
    private static Scanner sc = new Scanner(System.in);
    private static File archivo = new File("adt1_practica3/src/main/resources/vehiculos.data");


    Vehiculo uno = new Vehiculo(Marca.AUDI, Modelo.A3, "3454sdr", "125cv", "Verde");
    Vehiculo dos = new Vehiculo(Marca.MERCEDES, Modelo.CLA, "3454srr", "165cv", "Verde");
    Vehiculo tres = new Vehiculo(Marca.BMW, Modelo.S3, "3454mmm", "165cv", "Naranja");
    Vehiculo cuatro = new Vehiculo(Marca.VOLKSKWAGEN, Modelo.GOLF, "3444ddr", "225cv", "rojo");


    public static void main(String[] args) {


        String entrada = "";

        do {
            opciones();
            entrada = sc.nextLine();
            switch (entrada) {
                case "0":
                    break;
                case "1":
                    InsertarVehiculo();
                    break;
                case "2":
                    VisualizarVehiculo();
                    break;
                case "3":
                    BuscarPorMatricula();
                    break;
                case "4":
                    ListarPorPotencia();
                    break;
                default:
                    System.out.println("Opcion no valida");
            }

        } while (!entrada.equals("0"));

        System.out.println("Fin de programa!!!");

    }

    private static void ListarPorPotencia() {

        ArrayList<Vehiculo> vehiculos = new ArrayList<>();

        try (ObjectInputStream oi = new ObjectInputStream(new FileInputStream(archivo))) {
            while (true) {
                try {
                    vehiculos.add((Vehiculo) oi.readObject());
                } catch (EOFException e) {
                    break; //salir
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        vehiculos.stream()
                .sorted(Comparator.comparing(Vehiculo::getPotencia))
                .forEach(System.out::println);
/*
        for (Vehiculo v : vehiculos){
            System.out.println(v.toString());
        }

 */
    }

    private static void BuscarPorMatricula() {
        System.out.println("Introducir matricula");
        String entrada = sc.nextLine();

        try (ObjectInputStream oi = new ObjectInputStream(new FileInputStream(archivo))) {

            while (true) {
                try {
                    Vehiculo vehiculo = (Vehiculo) oi.readObject();
                    if (vehiculo.getMatricula().equalsIgnoreCase(entrada)) {
                        System.out.println("Matricula encontrada");
                        System.out.println(vehiculo.toString());
                        break;
                    }
                } catch (EOFException e) {
                    break;
                }
            }

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Saliendo de busqueda matricula");
    }

    private static void VisualizarVehiculo() {
        try (ObjectInputStream oi = new ObjectInputStream(new FileInputStream(archivo))) {

            while (true) {
                try {
                    Vehiculo vehiculo = (Vehiculo) oi.readObject();
                    System.out.println(vehiculo.toString());
                } catch (EOFException e) {
                    break;
                }
            }

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void InsertarVehiculo() {
        try {
            if (archivo.exists() && archivo.length() > 0) {
                System.out.println("Archivo vacio: " + archivo.length());
                //mi object
                SiguienteRegistro sr = new SiguienteRegistro(new FileOutputStream(archivo, true));
                sr.writeObject(insertarDatos());
                sr.close();

            } else {
                // primera entrada
                System.out.println("Tamaño del archivo " + archivo.length());
                ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(archivo));
                oo.writeObject(insertarDatos());
                oo.close();
            }
            System.out.println("Escrito en documento: ocupa: " + archivo.length());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Vehiculo insertarDatos() {
        System.out.println("Escribe la marca:");
        Marca marca = Marca.valueOf(sc.nextLine());
        System.out.println("Escribe el modelo;");
        Modelo modelo = Modelo.valueOf(sc.nextLine());
        System.out.println("Matricula");
        String matricula = sc.nextLine();
        System.out.println("Potencia");
        String potencia = sc.nextLine();
        System.out.println("Color");
        String color = sc.nextLine();

        return new Vehiculo(marca, modelo, matricula, potencia, color);
    }

    private static void opciones() {
        String texto = """
                Elige una opción:
                Opcion 1.- Insertar Vehicula
                Opcion 2.- Visualizar Vehiculos
                Opcion 3.- Buscar por Matricula
                Opcion 4.- Listar por Potencia
                Opcion 0.- Salir
                """;
        System.out.println(texto);
    }
}