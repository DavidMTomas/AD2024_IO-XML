package com.damato;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.OutputStream;

public class App {
    public static void main(String[] args) {

        try {
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();

            Element raiz = doc.createElement("peliculas");
            doc.appendChild(raiz);

            Element pelicula = doc.createElement("pelicula");
            pelicula.setAttribute("codigo","");
            raiz.appendChild(pelicula);

            Element titulo = doc.createElement("titulo");
            pelicula.appendChild(titulo);

            Element director = doc.createElement("director");
            pelicula.appendChild(director);

            Element actores = doc.createElement("actores");
            pelicula.appendChild(actores);



            Transformer crear = TransformerFactory.newInstance().newTransformer();
            crear.setOutputProperty(OutputKeys.METHOD, "xml");
            crear.setOutputProperty(OutputKeys.INDENT,"yes");
            crear.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM,"cartelera.dtd");

            crear.transform(new DOMSource(doc),new StreamResult(new File("adt2_practica0/src/main/resources/cartelera.xml")));



        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (TransformerConfigurationException e) {
            throw new RuntimeException(e);
        } catch (TransformerException e) {
            throw new RuntimeException(e);
        }


    }
}