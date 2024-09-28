package com.damato;

import java.io.Serializable;

public class Vehiculo implements Serializable {
    private Enum Marca;
    private Enum Modelo;
    private String matricula;

    private String potencia;
    private String color;




    public Vehiculo(Enum marca, Enum modelo, String matricula, String potencia, String color) {
        Marca = marca;
        Modelo = modelo;
        this.matricula = matricula;
        this.potencia = potencia;
        this.color = color;
    }
}
