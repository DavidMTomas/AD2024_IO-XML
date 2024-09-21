import java.io.File;
import java.util.Arrays;

public class Adt1_ejemplo2 {
    // Realiza un programa que muestre el directorio raiz, todas las unidades de disco y todos los archivos del directorio raiz
    public static void main(String[] args) {
        directorioRaiz();
        unidadesDisco();
        archivosDirectorioRaiz();
    }

    private static void archivosDirectorioRaiz() {
        File raiz = File.listRoots()[0];
        System.out.printf("Archivos del directorio raiz: %d \n", Arrays.stream(raiz.listFiles()).filter(f->f.isFile()).count());
        Arrays.stream(raiz.listFiles()).filter(f->f.isFile()).forEach(System.out::println);
    }

    private static void unidadesDisco() {
        System.out.println("Las unidadesd e disco son:");
         Arrays.stream(File.listRoots()).forEach(System.out::println);
    }

    private static void directorioRaiz() {
        File directorio = File.listRoots()[0];
        System.out.println("El directorio raiz es: "+ directorio);
    }
}
