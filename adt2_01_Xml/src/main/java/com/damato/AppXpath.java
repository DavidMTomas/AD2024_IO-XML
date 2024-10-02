package com.damato;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.IOException;

public class AppXpath {
    static Document dom;
    public static void main(String[] args) {
        //metodo uno para busqueda libros en venta del xml libros
        try {
            accederArbol();
            metodoDom();
            metodoXPath();




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

    private static void metodoXPath() throws XPathExpressionException {
        System.out.println("METODO CON XPATH");
        // /libros/venta/libro   - //venta//*
        XPath xpath = XPathFactory.newInstance().newXPath();
        Element root = (Element) xpath.evaluate("/*",dom,XPathConstants.NODE);
        System.out.println("El nombre del xml es: "+root.getNodeName());
        System.out.println("******************************");
        NodeList atributoslibros = (NodeList) xpath.evaluate("//venta/libro/*",dom, XPathConstants.NODESET);
        System.out.println("Libro");
        for (int i=0; i<atributoslibros.getLength();i++){
            Node atributo = atributoslibros.item(i);
            if(atributo instanceof Element){
                System.out.println(atributo.getNodeName()+" : "+atributo.getTextContent());
            }
        }
        System.out.println("-------------------------");

    }

    private static void metodoDom() {
        System.out.println("METODO CON DOM");
        Element raiz = dom.getDocumentElement();
        System.out.println("El nombre del xml es: "+raiz.getNodeName());
        int contador=0;
        System.out.println("******************************");
        NodeList lista = raiz.getChildNodes();
        // venta o prestamo
        for (int i=0;i<lista.getLength();i++){
            Node node = lista.item(i);
            if(node instanceof Element){
                if(node.getNodeName().equalsIgnoreCase("venta")){
                    System.out.println("Libros en venta");
                    NodeList libros = node.getChildNodes();
                    //cada libro
                    for (int j =0; j<libros.getLength();j++){
                        Node libro = libros.item(j);
                        if(libro instanceof Element){
                            System.out.println(libro.getNodeName());
                            contador++;
                            // atributos libro
                            NodeList atributos=libro.getChildNodes();
                            for(int x =0; x<atributos.getLength();x++){
                                Node atributo = atributos.item(x);
                                if(atributo instanceof Element){
                                    System.out.println(atributo.getNodeName()+": "+atributo.getTextContent());


                                }
                            }
                            System.out.println("-------------------------");

                        }
                    }
                }
            }

        }
        System.out.println("Hay " + contador + " libros en venta");
        System.out.println("******************************");

    }

     static void accederArbol() throws ParserConfigurationException, IOException, SAXException {
        File file = new File("adt2_01_Xml/src/main/resources/libros.xml");
        if(file.exists())
            System.out.println("El archivo existe");
        dom = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);
        dom.getDocumentElement().normalize();
    }
}
