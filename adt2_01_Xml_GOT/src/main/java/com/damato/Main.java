package com.damato;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.management.modelmbean.ModelMBean;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
/*
        try {
            crearArbol();
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (TransformerConfigurationException e) {
            throw new RuntimeException(e);
        } catch (TransformerException e) {
            throw new RuntimeException(e);
        }
*/


      // anyadirPersonaje();

        modificarPersonaje();




    }

    private static void modificarPersonaje() {


    }

    private static void anyadirPersonaje() {
        try {
            Document dom = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("adt2_01_Xml_GOT/src/main/resources/gamoftrones.xml");
            dom.getDocumentElement().normalize();

            Element raiz= dom.getDocumentElement();



            Element familia = dom.createElement("familia");
            familia.setAttribute("nombre","Lannister");
            //raiz.getFirstChild().getNextSibling().appendChild(familia);
            raiz.getElementsByTagName("familias").item(0).appendChild(familia);

            Element personaje = dom.createElement("personaje");
            personaje.setAttribute("id","4");
            familia.appendChild(personaje);


            Element nombre= dom.createElement("nombre");
            nombre.setTextContent("Tyrion Lannister");
            personaje.appendChild(nombre);

            Element titulo = dom.createElement("titulo");
            titulo.setTextContent("Hand of the Queen");
            personaje.appendChild(titulo);

            Element relaciones = dom.createElement("relaciones");
            personaje.appendChild(relaciones);

            Element hermano = dom.createElement("hermano");
            hermano.setTextContent("Jaime Lannister");
            relaciones.appendChild(hermano);

            Element hermana = dom.createElement("hermana");
            hermana.setTextContent("Cresei Lannister");
            relaciones.appendChild(hermana);



            Transformer anyadir = TransformerFactory.newInstance().newTransformer();
            anyadir.setOutputProperty(OutputKeys.METHOD,"xml");
            anyadir.setOutputProperty(OutputKeys.INDENT,"yes");
            anyadir.transform(new DOMSource(dom),new StreamResult(new File("adt2_01_Xml_GOT/src/main/resources/gamoftrones2.xml")));



        } catch (SAXException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (TransformerConfigurationException e) {
            throw new RuntimeException(e);
        } catch (TransformerException e) {
            throw new RuntimeException(e);
        }
    }

    private static void crearArbol() throws ParserConfigurationException, TransformerException {
        Document dom =  DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();

        Element root =dom.createElement("game_of_thrones");
        dom.appendChild(root);

        Element familias = dom.createElement("familias");
        root.appendChild(familias);

        Element familia = dom.createElement("familia");
        familia.setAttribute("nombre","Stark");
        familias.appendChild(familia);

        Element personaje = dom.createElement("personaje");
        personaje.setAttribute("id","1");
        familia.appendChild(personaje);

        Element nombre = dom.createElement("nombre");
        nombre.setTextContent("Eddard Stark");
        personaje.appendChild(nombre);

        Element titulo = dom.createElement("titulo");
        titulo.setTextContent("Lord of Winterfell");
        personaje.appendChild(titulo);

        Element relaciones  = dom.createElement("relaciones");
        personaje.appendChild(relaciones);

        Element esposo = dom.createElement("esposo");
        esposo.setTextContent("Catelyn Stark");
        relaciones.appendChild(esposo);

        Element hijos = dom.createElement("hijos");
        relaciones.appendChild(hijos);

        Element hijo1 = dom.createElement("hijo");
        hijo1.setTextContent("Robb Stark");
        hijos.appendChild(hijo1);

        Element hija1 = dom.createElement("hija");
        hija1.setTextContent("Sansa Stark");
        hijos.appendChild(hija1);

        Element hijo2 = dom.createElement("hijo");
        hijo2.setTextContent("Bran Stark");
        hijos.appendChild(hijo2);

        Element hija2 = dom.createElement("hija");
        hija2.setTextContent("Arya Stark");
        hijos.appendChild(hija2);

        Element hijo3 = dom.createElement("hijo");
        hijo3.setTextContent("Rickon Stark");
        hijos.appendChild(hijo3);

        ////// jhon nieve  ///
        Element personaje2 = dom.createElement("personaje");
        personaje2.setAttribute("id","3");
        familia.appendChild(personaje2);

        Element nombre2 = dom.createElement("nombre");
        nombre2.setTextContent("Jon snow");
        personaje2.appendChild(nombre2);

        Element titulo2 = dom.createElement("titulo");
        titulo2.setTextContent("King in the nord");
        personaje2.appendChild(titulo2);

        Element relaciones2  = dom.createElement("relaciones");
        personaje2.appendChild(relaciones2);

        Element padre = dom.createElement("padre");
        padre.setTextContent("Rhaegar Targaryen");
        personaje2.appendChild(padre);

        Element madre = dom.createElement("madre");
        madre.setTextContent("Lyana Stark");
        personaje2.appendChild(madre);

        // danerys
        Element familiaTar = dom.createElement("familia");
        familiaTar.setAttribute("id","Targaryen");
        familias.appendChild(familiaTar);

        Element perTar = dom.createElement("personaje");
        perTar.setAttribute("id","2");
        familiaTar.appendChild(perTar);

        Element nombreDan= dom.createElement("nombre");
        nombreDan.setTextContent("Daenerys Targaryen");
        perTar.appendChild(nombreDan);


        Element titDAn = dom.createElement("titulo");
        titDAn.setTextContent("Mother of Dragons");
        perTar.appendChild(titDAn);

        Element relDan = dom.createElement("relaciones");
        perTar.appendChild(relDan);

        Element herDan = dom.createElement("hermano");
        herDan.setTextContent("Viserys Targaryen");
        relDan.appendChild(herDan);


        Element esDan = dom.createElement("esposo");
        esDan.setTextContent("Khal Drogo");
        relDan.appendChild(esDan);



        // convertir a xml
        Transformer convertir = TransformerFactory.newInstance().newTransformer();
        convertir.setOutputProperty(OutputKeys.METHOD,"xml");
    convertir.setOutputProperty(OutputKeys.INDENT,"yes");

        convertir.transform(new DOMSource(dom),
                new StreamResult(new File("adt2_01_Xml_GOT/src/main/resources/gamoftrones.xml")));


    }
}