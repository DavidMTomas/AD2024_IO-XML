package com.damato;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class GestionArchivos {
    private String rutaTrabajo;
    private String nuevaCarpeta;
    private String nombreArchivo;

    public GestionArchivos(String rutaTrabajo, String nuevaCarpeta, String nombreArchivo) {
        this.rutaTrabajo = "adt1_practica1/src/main/resources/";
        this.nuevaCarpeta = "";
        this.nombreArchivo = "";
    }


    public String getRutaTrabajo() {
        return rutaTrabajo;
    }

    public void setRutaTrabajo(String rutaTrabajo) {
        this.rutaTrabajo = rutaTrabajo;
    }

    public String getNuevaCarpeta() {
        return nuevaCarpeta;
    }

    public void setNuevaCarpeta(String nuevaCarpeta) {
        this.nuevaCarpeta = nuevaCarpeta;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public void asignarRutaTrabajo(Scanner sc) {
        int contador = 0;
        System.out.println("Indicar la ruta de trabajo:");
        // mostramos la ruta actual y luego listamos las rutas del sistema
        System.out.println(++contador + "-.  " + System.getProperty("user.dir"));
        for (File actual : File.listRoots()) {
            if (actual.isDirectory()) System.out.println(++contador + "-.  " + actual.getAbsolutePath());
        }

        String ruta = sc.nextLine();
        File directorio = null;
        switch (ruta) {
            case "1":
                directorio = new File("adt1_practica1/src/main/resources/");
                break;
            case "2":
                directorio = File.listRoots()[0];
                break;
            case "3":
                directorio = File.listRoots()[1];
                break;
            default:
                System.out.println("Opcion no valida");
                break;
        }
        if (directorio != null && directorio.isDirectory()) {
            System.out.println("Directorio seleccionado: " + directorio.getAbsolutePath());
            setRutaTrabajo(directorio.toString());
        } else {
            System.out.println("Directorio no encontrado");
        }
    }

    public void listarRuta() {
        File ruta = new File(getRutaTrabajo());
        System.out.println("Listado de la ruta: " + ruta.getAbsolutePath() + " longitud " + ruta.length());
        for (File actual : ruta.listFiles()) {
            if (ruta.listFiles().length > 0) {
                if (actual.isDirectory()) System.out.println("Directorio: " + actual.getName());
                else if (actual.isFile()) System.out.println("Fichero: " + actual.getName());
            } else System.out.println("La ruta esta vacia");
        }

    }

    public void crearCarpeta(Scanner sc) {
        System.out.println("Escribe el nombre de la carpeta: ");
        String carpeta = sc.nextLine().trim();

        System.out.println("Se creara la carpera " + carpeta + " en la ruta: " + getRutaTrabajo());
        File nuevaCarpeta = new File(getRutaTrabajo(), carpeta);
        System.out.println(nuevaCarpeta.mkdir() ? "Carpeta creada: " + nuevaCarpeta.getAbsolutePath() : "Error al crear la carpeta");
        setNuevaCarpeta(nuevaCarpeta.toString());

    }

    public void informacioDetalladaArchivo(Scanner sc) {
        System.out.println("Escribe el nombre del archivo/carpeta para obtener información ");
        File entrada = new File(getRutaTrabajo(), sc.nextLine().trim());
        if (!entrada.isFile() && !entrada.isDirectory())
            System.out.println("La entrada " + entrada.getName() + " no es valida");
        else {
            System.out.println("Nombre: " + entrada.getName());
            if (entrada.isDirectory()) System.out.println("Tipo: Carptea");
            else if (entrada.isFile()) System.out.println("Tipo: Fichero");
            System.out.println("Longitud: " + entrada.length());
            System.out.println("Ubicacion: " + entrada.getAbsolutePath());
            System.out.println("ultima modificación: " + new SimpleDateFormat("EEEE, dd/MM/yyyy").format(entrada.lastModified()));
            System.out.println("Oculto: " + (entrada.isHidden() ? "Si" : "No"));
        }
    }

    public void crearFichero(Scanner sc) {
        System.out.println("Escribe el nombre del fichero: ");
        String fichero = sc.nextLine().trim();
        setNombreArchivo(fichero);
        File nuevoArchivo = new File(getRutaTrabajo(), fichero);
        try {
            System.out.println(nuevoArchivo.createNewFile() ? "Archivo creado: " + nuevoArchivo.getAbsolutePath() : "Error al crear el archivo");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void eliminarFichero(Scanner sc) {
        System.out.println("Escribe el nombre del fichero que deseas eliminar: ");
        String fichero = sc.nextLine().trim();
        File nuevoArchivo = new File(getRutaTrabajo(), fichero);
        if (nuevoArchivo.exists() && nuevoArchivo.isFile())
            System.out.println(nuevoArchivo.delete() ? "Archivo eliminado: " : "Error al eliminar el archivo");
        else System.out.println("El ficho no existe");
    }
}
