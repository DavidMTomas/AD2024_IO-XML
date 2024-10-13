package com.damato;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.File;

public class Ejercicio2 {
    public static void main(String[] args) {
        XmlCtrlDom xml = new XmlCtrlDom();
        File ruta = new File("adt2_practica1/src/main/resources/ejercicio2.xml");

        try {
            Document doc = xml.instanciarDocument();

            Element alumnos = doc.createElement("alumnos");
            doc.appendChild(alumnos);

            Element alumno = doc.createElement("alumno");
            alumnos.appendChild(alumno);

            Element nombre= doc.createElement("nombre");
            nombre.setTextContent("Juan");
            alumno.appendChild(nombre);

            Element apellidos=doc.createElement("apellidos");
            apellidos.setTextContent("Marti Lopez");
            alumno.appendChild(apellidos);

            Element edad = doc.createElement("edad");
            edad.setTextContent("18");
            alumno.appendChild(edad);
            //////////////////////////////
            Element alumno2 = doc.createElement("alumno");
            alumnos.appendChild(alumno2);

            Element nombre2= doc.createElement("nombre");
            nombre2.setTextContent("Amparo");
            alumno2.appendChild(nombre2);

            Element apellidos2=doc.createElement("apellidos");
            apellidos2.setTextContent("Luna Dolores");
            alumno2.appendChild(apellidos2);

            Element edad2 = doc.createElement("edad");
            edad2.setTextContent("25");
            alumno2.appendChild(edad2);


            xml.escribirDocumentAXmlFichero(doc,ruta);
            System.out.println("ejercicio 2 terminado");





        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (TransformerException e) {
            throw new RuntimeException(e);
        }

    }
}
