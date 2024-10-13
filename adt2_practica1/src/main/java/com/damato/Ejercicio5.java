package com.damato;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ejercicio5 {
    static ArrayList<Ejercicio4.Alumne> alumnesAsix;
    static ArrayList<Ejercicio4.Alumne> alumnesDam;
    static ArrayList<Ejercicio4.Alumne> alumnes;

    public static void main(String[] args) {
        alumnesDam = new ArrayList<>();
        alumnesAsix = new ArrayList<>();
        alumnes = new ArrayList<>();
        File ruta = new File("adt2_practica1/src/main/resources/ejercicio4.xml");
        XmlCtrlDom xml = new XmlCtrlDom();
        try {

            version2(xml, ruta);

            imprimiAlumnos();


            System.out.println("Buscar alumnos dam");
            alumnes.stream().filter(it ->it.getCurs().toLowerCase().equals("2ndam")).forEach(System.out::println);

            System.out.println("Buscar Alumnos asix");
           List<String> alumnosAsix= alumnes.stream().filter(it->it.getCurs().toLowerCase().contains("asix")).map(it -> it.getNom()).collect(Collectors.toList());
            System.out.println(alumnosAsix);


        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);

        }
    }

    private static void imprimiAlumnos() {
        System.out.println("Imprimir por cada array");
        System.out.println("DAM");
        alumnesDam.stream().forEach(System.out::println);
        System.out.println("ASIX");
        alumnesAsix.stream().forEach(System.out::println);
    }


    private static void version2(XmlCtrlDom xml, File ruta) throws ParserConfigurationException, IOException, SAXException {
        Document doc = xml.instanciarDocument(ruta);
        Element raiz = doc.getDocumentElement();
        String id = "";
        String nom = "";
        String cognom = "";
        String curs = "";

        //recorremos los alumnos
        for (int i = 0; i < raiz.getChildNodes().getLength(); i++) {
            NodeList elemento = (NodeList) raiz.getChildNodes().item(i);
            if (elemento instanceof Element) {
                id = ((Element) elemento).getAttribute("id");
                for (int j = 0; j < elemento.getLength();j++) {
                    Node attEl = elemento.item(j);
                    if (attEl instanceof Element) {
                        switch (attEl.getNodeName()) {
                            case "nom":
                                nom = attEl.getTextContent();
                                break;
                            case "cognom":
                                cognom = attEl.getTextContent();
                                break;
                            case "curs":
                                curs = attEl.getTextContent();
                                break;
                        }

                    }
                }
                Ejercicio4.Alumne a = new Ejercicio4.Alumne(id, nom, cognom, curs);
                if(a.getCurs().toLowerCase().equals("2ndam")) {
                    alumnesDam.add(a);
                    alumnes.add(a);
                }
                else {
                    alumnesAsix.add(a);
                    alumnes.add(a);
                }
            }
        }
    }

}
