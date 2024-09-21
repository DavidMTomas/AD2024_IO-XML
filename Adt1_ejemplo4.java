import java.io.*;

public class Adt1_ejemplo4 {
    //Realiza un programa que abra un fichero de texto para escribir una frase

    public static void main(String[] args) {
        String ruta ="./adt1_ejemplo1/src/main/resources/";
        File fichero= new File(ruta+"fichero.txt");

        String texto="Este es el texto escrito en ";

        try {
            escribirFileWriter(fichero, texto, "FileWriter\n");
            escribirPrintWriter(fichero, texto, "PrintWriter\n");
            escribirBufferedWriter(fichero, texto, "BufferedWriter\n");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private static void escribirBufferedWriter(File fichero, String texto, String s) throws IOException {
        texto +=s;
        BufferedWriter bw=new BufferedWriter(new FileWriter(fichero, true));

        bw.write(texto);
        System.out.println("Metodo escribirBufferedWriter completado");
        bw.close();
    }

    private static void escribirPrintWriter(File fichero, String texto, String printWriter) throws IOException {
        texto +=printWriter;
        PrintWriter pw = new PrintWriter(new FileWriter(fichero,true));

        pw.print(texto);
        System.out.println("Metodo escribirPrintWriter completado");
        pw.close();
    }

    private static void escribirFileWriter(File fichero, String texto, String fileWriter) throws IOException {
        texto +=fileWriter;
        FileWriter fw = new FileWriter(fichero, true);

        fw.write(texto);
        System.out.println("Metodo escribirFileWriter completado");
        fw.close();
    }


}
