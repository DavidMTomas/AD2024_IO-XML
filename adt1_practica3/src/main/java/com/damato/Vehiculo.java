package com.damato;

import java.io.Serializable;

public class Vehiculo implements Serializable {
    private Enum Marca;
    private Enum Modelo;
    private String matricula;

    private String potencia;
    private String color;

    @Override
    public String toString() {
        return "Vehiculo{" +
                "Marca=" + Marca +
                ", Modelo=" + Modelo +
                ", matricula='" + matricula + '\'' +
                ", potencia='" + potencia + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    public Enum getMarca() {
        return Marca;
    }

    public void setMarca(Enum marca) {
        Marca = marca;
    }

    public Enum getModelo() {
        return Modelo;
    }

    public void setModelo(Enum modelo) {
        Modelo = modelo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getPotencia() {
        return potencia;
    }

    public void setPotencia(String potencia) {
        this.potencia = potencia;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Vehiculo(Enum marca, Enum modelo, String matricula, String potencia, String color) {
        Marca = marca;
        Modelo = modelo;
        this.matricula = matricula;
        this.potencia = potencia;
        this.color = color;
    }
}
