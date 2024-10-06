package com.damato;
//practicas del ejercicio xpath del 1 al 17 https://chatgpt.com/share/67022e5c-78a8-8005-b385-61ef9a854c24

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.IOException;

public class ejercicio18 {
private final static String RUTA="adt2_practica0/src/main/resources/biblioteca.xml";
    public static void main(String[] args) {

        // seleccionar todos los titulos
        seleccionarTodosLosTitulos();

        //sleccionar el titulo del primer libro
        tituloPrimerLibro();

        //Seleccionar todos los precios:
        seleccionarPrecio();


        //Seleccionar los nodos de precio que su precio sea mayor a 35:
        precioMayorDe(40);






    }

    private static void precioMayorDe(int precio) {
        try {
            Document dom = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(RUTA);
            XPath xpath = XPathFactory.newInstance().newXPath();


            NodeList lista= (NodeList) xpath.evaluate("//book[price>"+precio+"]/title",dom,XPathConstants.NODESET);

            System.out.println("Seleccionar los nodos de precio que su precio sea mayor a :"+precio);
            for (int i = 0; i< lista.getLength(); i++){
                System.out.println(lista.item(i).getTextContent());
            }


            System.out.println("        Forma diferente");
            NodeList lista2 = (NodeList) xpath.evaluate("//book[price>"+precio+"]",dom, XPathConstants.NODESET);
            for (int i = 0; i< lista.getLength(); i++){
                NodeList libro = lista2.item(i).getChildNodes();
                for (int j=0;j<libro.getLength();j++){
                    if(libro.item(j) instanceof Element){
                        if(libro.item(j).getNodeName().equals("title")){
                            System.out.println("Nombre del libro: "+libro.item(j).getTextContent());
                        }
                        if(libro.item(j).getNodeName().equals("price")){
                            System.out.println("Precio: "+libro.item(j).getTextContent());
                        }
                    }
                }
            }
        } catch (SAXException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (XPathExpressionException e) {
            throw new RuntimeException(e);
        }
    }

    private static void seleccionarPrecio() {
        try {
            Document dom =DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(RUTA);
            XPath xpath = XPathFactory.newInstance().newXPath();
            NodeList precios = (NodeList) xpath.evaluate("//price",dom,XPathConstants.NODESET);

            for (int i=0;i<precios.getLength();i++){
                if(precios.item(i) instanceof Element){
                    System.out.println("Precio: "+precios.item(i).getTextContent());
                }
            }

        } catch (SAXException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (XPathExpressionException e) {
            throw new RuntimeException(e);
        }

    }

    private static void tituloPrimerLibro() {
        try {
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(RUTA);
            XPath xpath = XPathFactory.newInstance().newXPath();

            Element libro = (Element) xpath.evaluate("/bookstore/book[1]/title",doc,XPathConstants.NODE);

            System.out.println("El titulo del prmeir libro es");
            System.out.println(libro.getNodeName()+ ": "+libro.getTextContent());

            System.out.println("Otra forma");
            String titulo = (String) xpath.evaluate("//title[1]",doc,XPathConstants.STRING);
            System.out.println(titulo);

        } catch (SAXException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (XPathExpressionException e) {
            throw new RuntimeException(e);
        }
    }

    private static void seleccionarTodosLosTitulos() {
        try {
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("adt2_practica0/src/main/resources/biblioteca.xml");
            XPath xpath=XPathFactory.newInstance().newXPath();

            NodeList lista = (NodeList) xpath.evaluate("//title",doc,XPathConstants.NODESET);

            for(int i=0; i< lista.getLength();i++){

                if(lista.item(i) instanceof Element){
                    System.out.println(lista.item(i).getNodeName()+": "+lista.item(i).getTextContent());
                }
            }






        } catch (SAXException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (XPathExpressionException e) {
            throw new RuntimeException(e);
        }

    }


}
