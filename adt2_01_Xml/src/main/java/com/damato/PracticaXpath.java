package com.damato;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.IOException;

public class PracticaXpath {
    private static XPath xPath;
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, XPathExpressionException {
        AppXpath.accederArbol();
        xPath = XPathFactory.newInstance().newXPath();
        //prestamo y libro
        tipos();
        // libros despues del año 2005
        publicacionAnyo(2005);



    }

    private static void publicacionAnyo(int i) throws XPathExpressionException {

        NodeList librosAnyo = (NodeList) xPath.evaluate("//anyo",AppXpath.dom,XPathConstants.NODESET);
        System.out.println("Total "+librosAnyo.getLength());
       for (int j=0; j<librosAnyo.getLength(); j++){
           Node nodo = librosAnyo.item(j);
           if (nodo instanceof Element){
               int anyo= Integer.parseInt(nodo.getTextContent());
               if(anyo>=i){
                   System.out.println("Libro del año: "+nodo.getTextContent()+" libro: "+nodo.getParentNode().getFirstChild().getNextSibling().getTextContent());
               }
           }
       }

    }

    private static void tipos() throws XPathExpressionException {
        NodeList tipos = (NodeList) xPath.evaluate("/libros/*",AppXpath.dom, XPathConstants.NODESET);
        recorrerNodos(tipos);
    }

    private static void recorrerNodos(NodeList nodos) {
        System.out.println("Elementos hijos del padre: "+nodos.item(0).getParentNode().getNodeName());
        for(int i=0; i<nodos.getLength();i++){
            Node nodo =  nodos.item(i);
                if(nodo instanceof Element){
                    System.out.println(nodo.getNodeName());
                }
            }

    }
}
