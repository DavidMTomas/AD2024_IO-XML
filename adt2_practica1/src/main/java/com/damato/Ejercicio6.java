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
import java.util.Comparator;

public class Ejercicio6 {
    static ArrayList<Ejercicio4.Alumne> alumnes;
    public static void main(String[] args) {
        alumnes = new ArrayList<>();
        File ruta = new File("adt2_practica1/src/main/resources/ejercicio6.xml");
        XmlCtrlDom xml = new XmlCtrlDom();
        try {

            version2(xml, ruta);


            System.out.println("Alumnos ordenados de mayor a menor nota");
            alumnes.stream().sorted(Comparator.reverseOrder()).forEach(it-> System.out.println(it.toString2()));


        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);

        }

    }


        private static void version2(XmlCtrlDom xml, File ruta) throws ParserConfigurationException, IOException, SAXException
        {
            Document doc = xml.instanciarDocument(ruta);
            Element raiz = doc.getDocumentElement();
            String id = "";
            String nom = "";
            String cognom = "";
            String nota = "";
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
                                case "nota":
                                    nota = attEl.getTextContent();
                                    break;
                                case "curs":
                                    curs = attEl.getTextContent();
                                    break;
                            }

                        }
                    }
                    Ejercicio4.Alumne a = new Ejercicio4.Alumne(id, nom, cognom,nota, curs);
                    System.out.println(a.toString2());
                        alumnes.add(a);
                    }
                }
            }
        }







