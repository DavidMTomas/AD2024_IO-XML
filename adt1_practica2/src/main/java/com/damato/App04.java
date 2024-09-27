package com.damato;

import java.io.*;

//Comparar si 2 ficheros son iguales
public class App04 {
    public static void main(String[] args) {
        File file1 = new File("adt1_practica2/src/main/resources/compare1.txt");
        File file2 = new File("adt1_practica2/src/main/resources/compare2.txt");

        System.out.print(compareFileContent(file1, file2) ? "cierto" : "falso");
    }

    private static boolean compareFileContent(File file1, File file2) {
        if (file1.length() != file2.length()) return false;

        String linea1 = "";
        String linea2 = "";
        try {

            BufferedReader br1 = new BufferedReader(new FileReader(file1));
            BufferedReader br2 = new BufferedReader((new FileReader(file2)));

            while ((linea1 = br1.readLine()) != null && (linea2 = br2.readLine()) != null) {
                if (!linea1.equals(linea2)) return false;

            }

            // Verifica si ambos archivos han sido leídos completamente
            if (br1.readLine() != null || br2.readLine() != null) {
                return false;
            }

            return true;

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

