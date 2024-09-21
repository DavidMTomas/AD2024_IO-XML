import java.io.File;

public class Adt1_ejemplo3 {
    //Visualiza el sistema de archivos en el directorio actual
    public static void main(String[] args) {
        File direcActual = new File(".");

        if (direcActual.isDirectory()) listarContenido(direcActual);
        else if (direcActual.isFile()) System.out.printf("Nombre archivo:  %s", direcActual.getName());
        else System.out.println("No es ni un archivo ni un directorio");

    }

    private static void listarContenido(File direcActual) {
        System.out.println("Nombre de directorio: " + direcActual.getName());
        for (File actual : direcActual.listFiles()) {
            if (actual.isDirectory()) listarContenido(actual);
            else System.out.printf("   Nombre del archivo: " + actual.getName());
        }
    }
}
