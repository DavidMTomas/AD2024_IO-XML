package com.damato;

import java.io.*;

public class App {
    public static void main(String[] args) {


        String nombre= "./adt1_ejemplo7/src/main/resources/ejemploObjeto1.data";
        Punto punto = new Punto(52,5);

        //Escritura objeto
        escrituraObjeto(nombre, punto);


        //Lectura objeto
        lecturaObjeto(nombre);



    }

    private static void lecturaObjeto(String nombre) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombre))) {
           Punto lecturaPunto=(Punto) ois.readObject();
            System.out.println(lecturaPunto);

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    private static void escrituraObjeto(String nombre, Punto punto) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombre))) {
            oos.writeObject(punto);

        }catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}