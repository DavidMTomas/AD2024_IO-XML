package com.damato;

import java.io.Serializable;

public class Persona implements Serializable {
    String nombre;
    String apellido;
    int edad;
    Mascota mascota=new Mascota();

    public Persona(int i) {
        setPersona(i);
    }

    private void setPersona(int i) {
        this.nombre= "nombre "+i;
        this.apellido= "apellido "+i;
        this.mascota.setNombre("Fido "+i);
        this.mascota.setNumeroPatas(i);
        this.edad= i;
    }


    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", mascota=" + mascota.getNombre() +" patas="+mascota.getNumeroPatas() +
                '}';
    }


}
