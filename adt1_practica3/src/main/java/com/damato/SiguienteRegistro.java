package com.damato;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class SiguienteRegistro extends ObjectOutputStream {
    public SiguienteRegistro(OutputStream out) throws IOException {
        super(out);
    }

    protected SiguienteRegistro() throws IOException, SecurityException {
    }


    protected void writeStreamHeader() throws IOException {}

}
