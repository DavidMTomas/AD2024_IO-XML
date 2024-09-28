package com.damato;

import java.io.Serializable;

public enum Marca {
    AUDI(new Modelo[]{Modelo.A3, Modelo.A4}),
    BMW(new Modelo[]{Modelo.S3, Modelo.S5}),
    VOLKSKWAGEN(new Modelo[]{Modelo.GOLF, Modelo.TROC}),
    MERCEDES(new Modelo[]{Modelo.C, Modelo.CLA});


    private Modelo[] modelos;

    //constructor
    Marca(Modelo[] modelos) {
    this.modelos=modelos;
    }


    public Modelo[] getModelos(){
        return modelos;
    }
}



enum Modelo{
    A3,A4,S3,S5,TROC,GOLF,C,CLA
}
