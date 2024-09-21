import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Adt1_ejemplo5 {
    // Leer ficheros
    public static void main(String[] args) {
        String ruta = "./adt1_ejemplo1/src/main/resources/";
        File fichero = new File(ruta + "fichero.txt");

        try {
            leerFileReader(fichero, "FileReader");
            leerBufferedReader(fichero, "BufferedReader");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static void leerBufferedReader(File fichero, String bufferedReader) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fichero));
        System.out.println("            Metodo " + bufferedReader);
        System.out.println("-----------------------------------");

        String linea;

        while ((linea = br.readLine()) != null) {
            System.out.print(linea + "\n");
        }
        br.close();
        System.out.println("--------Lectura terminada-------------");
    }

    private static void leerFileReader(File fichero, String fileReader) throws IOException {
        FileReader fr = new FileReader(fichero);
        System.out.println("            Metodo " + fileReader);
        System.out.println("-----------------------------------");
        int caracter;
        while ((caracter = fr.read()) != -1) {
            System.out.print((char) caracter);
        }
        fr.close();
        System.out.println("--------Lectura terminada-------------");
    }
}
