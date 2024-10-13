package com.damato;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ejercicio3 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String entrada;
        XmlCtrlDom xml = new XmlCtrlDom();
        boolean salir = false;
        try {
            while (!salir) {
                mostarMenu();
                switch (entrada = sc.nextLine()) {
                    case "1": {
                        listadoXml(xml, "todo");
                        break;
                    }
                    case "2": {
                        listadoXml(xml, "prestamo");
                        break;
                    }
                    case "3": {
                        listadoXml(xml, "venta");
                        break;
                    }
                    case "4": {
                        salir = true;
                        break;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("error en el ejercicio");
        }
        System.out.println("Fin del ejercicio 3");
    }

    private static void listadoXml(XmlCtrlDom xml, String parametro) {

        try {
            Document doc = xml.instanciarDocument(new File("adt2_practica1/src/main/resources/ejercicio3.xml"));
            if (parametro.equals("todo")) xml.escribirDocumentAXmlPantalla(doc);
            else {
                NodeList libros = (NodeList) XPathFactory.newInstance().newXPath().evaluate("//"+ parametro + "/libro", doc, XPathConstants.NODESET);

                System.out.println("Listado de libros en: "+parametro);
                for (int i = 0; i < libros.getLength(); i++) {
                    NodeList libro = libros.item(i).getChildNodes();
                        for (int j = 0; j < libro.getLength();j++) {
                            Node elementos = libro.item(j);
                            if (elementos instanceof Element) System.out.println(elementos.getNodeName()+" "+elementos.getTextContent());
                        }
                    System.out.println();
                }
            }


        } catch (TransformerException e) {
            throw new RuntimeException(e);
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        } catch (XPathExpressionException e) {
            throw new RuntimeException(e);
        }


    }

    private static void mostarMenu() {
        String menu = """
                Opción 1.- Vista de todo el documento XML
                Opción 2.- Listado de los libros prestados
                Opción 3.- Listado de los libros en venta
                Opción 4.- Salir
                """;
        System.out.println(menu);
    }

}
