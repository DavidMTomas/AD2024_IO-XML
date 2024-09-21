import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Adt1_PasarTextoMayusculas {
    static String texto;
    static Scanner sc;
    // pasar a mayusculas un fichero
    public static void main(String[] args) throws IOException {

        sc=new Scanner(System.in);

        String ruta = "./adt1_ejemplo1/src/main/resources/";
        File fichero = new File(ruta + "pasarMayusculas.txt");
        // System.out.println(fichero.createNewFile());
        //averiguar si el documento esta en mayuscula
        verificarLetras(fichero);

        if(verificarLetrasArray(fichero)){
            System.out.println("Quieres convertir a minusculas?");
                convertirtexto("M", fichero);


        }else {
            System.out.println("Quieres convertir a mayusculas?");
                    convertirtexto("m", fichero);

        }




    }

    private static void convertirtexto(String tipo, File fichero) throws IOException {
        while (true){
            String resultado=sc.nextLine();
            resultado.toLowerCase();
            if(resultado.equals("si") || resultado.equals("no") ) break;
            else System.out.println("Valor no valido");
        }

        BufferedWriter bw = new BufferedWriter(new FileWriter(fichero));

        if(tipo.equals("m")){
            bw.write(texto.toUpperCase());
        }else bw.write(texto.toLowerCase());

        bw.close();

        System.out.println("Archivo convertido ");
    }



    private static boolean verificarLetrasArray(File fichero) throws IOException {
        FileReader fr = new FileReader(fichero);
        int caracter;
        Character letra;
        String[] palabras;

        while ((caracter = fr.read()) != -1) {
            letra = (char) caracter;
            texto += letra.toString();

        }

        palabras = texto.split(" ");

       // Arrays.stream(palabras).filter(p->p.chars().anyMatch(c->Character.isUpperCase((char) c))).forEach(System.out::println);

        long cantidad = Arrays.stream(palabras)
                .filter(palabra -> palabra.chars().anyMatch(c -> Character.isUpperCase((char) c))).
                count();

        System.out.println(cantidad == 1 ? "Hay una palabra en mayusculas" : "Hay " + cantidad + " palabras en mayusculas");



        if(cantidad>0) return true;
        else return false;
    }



    private static void verificarLetras(File fichero) throws IOException {
        FileReader fr = new FileReader(fichero);
        int caracter;
        String texto = "";
        Character letra;

        while ((caracter = fr.read()) != -1) {
            letra = (char) caracter;
            texto += letra.toString();
        }
        System.out.println(texto.toLowerCase().equals(texto) ? "Esta en minusculas todo el texto " : "Hay texto en mayusculas");
        fr.close();
    }

}