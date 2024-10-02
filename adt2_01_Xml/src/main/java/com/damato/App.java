package com.damato;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class App {
    public static void main(String[] args) {

       // Crear un Document

        try {
            Document documento= DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File("adt2_01_Xml/src/main/resources/biblioteca.xml"));
            //eliminar nodos de texto vacios
          documento.getDocumentElement().normalize();



            //Nodo raiz
            Element rootElement = documento.getDocumentElement();
            System.out.println("Nombre elemento raiz:"+rootElement.getNodeName());
            System.out.println("La zaiz es de tipo "+ rootElement.getNodeType());
            System.out.println("Valor "+rootElement.getNodeValue());
            NodeList lista = rootElement.getChildNodes();
            for(int i=0; i< lista.getLength();i++){
                Node node = lista.item(i);
                if(node instanceof Element)
                System.out.println(node.getNodeName());
            }

            // Recorrer arbol de nodos
            System.out.println("Padre de "+rootElement.getNodeName()+" es:"+rootElement.getParentNode().getNodeName());
            System.out.println("Primer hijo: "+rootElement.getFirstChild().getNodeName());
            System.out.println("Primer hijo hermano: "+rootElement.getFirstChild().getNextSibling().getNodeName());
            System.out.println("Ultimo hijo: elemento: "+rootElement.getLastChild().getNodeName()+" hermano de :"+rootElement.getLastChild().getPreviousSibling().getNodeName());


            //Acceder a un nodo concreto Libro con id L002
            NodeList concreto= rootElement.getElementsByTagName("libro");
            for (int i=0 ; i<concreto.getLength();i++){
                Node node = concreto.item(i);
                if(node instanceof Element){
                    System.out.println(node.getNodeName());
                    System.out.println(((Element) node).getAttribute("id"));
                }
            }

        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }
    }
}