package com.damato;

import java.io.*;

public class App {
    private static int contador=5;

    public static void main(String[] args) {
        String ruta = "adt1_ejemplo8/src/main/resources/mascotas.dat";
        File fichero = new File(ruta);


        try {
             escribeFichero(fichero);
             leeFichero(fichero);
             anyadeFichero(fichero);
             leeFichero2(fichero);


        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void anyadeFichero(File fichero) throws IOException {

        //  TRUE NECESARIO PARA AADIR REGISTROS , PUEDE GENERAR  java.io.StreamCorruptedException:
        try (MiObjectOutputStream mos = new MiObjectOutputStream(new FileOutputStream(fichero,true))) {

            for (; contador < 10; contador++) {
                Persona persona = new Persona(contador);
                mos.writeObject(persona);
            }
        }
        System.out.println("Metodo de AÑADIR terminado");
    }

    private static void leeFichero2(File fichero) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero))) {
            while (true) {
                try {
                    Object aux = ois.readObject();  // Intenta leer el objeto
                    if (aux instanceof Persona) {
                        System.out.println(aux);  // Imprime el objeto si es una instancia de Persona
                    }
                } catch (EOFException e) {
                    System.out.println("Fin de fichero");
                    break;  // Sale del bucle al alcanzar el final del archivo
                }
            }
        }
        System.out.println("        Metodo de LEER 2 terminado");
    }

    private static void leeFichero(File fichero) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero))) {
            Persona persona;
            while (true) {
                try {
                    persona = (Persona) ois.readObject();
                    System.out.println(persona.toString());
                } catch (EOFException e) {
                    break;
                }
            }
        }
        System.out.println("        Metodo de LEER terminado");
    }

    private static void escribeFichero(File fichero) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichero))) {
            for (contador = 0; contador < 5; contador++) {
                Persona persona = new Persona(contador);
                oos.writeObject(persona);
            }
        }
        System.out.println("Metodo de escritura terminado");
    }
}