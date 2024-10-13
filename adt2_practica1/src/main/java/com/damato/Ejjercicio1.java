package com.damato;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.IOException;

public class Ejjercicio1 {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, XPathExpressionException {
        XmlCtrlDom xml = new XmlCtrlDom();
        File ruta = new File("adt2_practica1/src/main/resources/ejercicio1.xml");

        Document doc = xml.instanciarDocument(ruta);

//        Element venta = (Element) XPathFactory.newInstance().newXPath().evaluate("//anyo",doc, XPathConstants.NODE);
//        System.out.println(venta.getNodeName());

        Element venta2 = (Element) doc.getElementsByTagName("venta").item(0);
        System.out.println(venta2.getNodeName());

        Element libro= doc.createElement("libro");
        venta2.appendChild(libro);

        libro.setAttribute("isbn","9788483468081");

        Element titulo= doc.createElement("titulo");
        titulo.setTextContent("Next");
        libro.appendChild(titulo);


        Element autor = doc.createElement("autor");
        autor.setTextContent("Michael Criton");
        libro.appendChild(autor);

        Element anyo = doc.createElement("anyo");
        anyo.setTextContent("2008");
        libro.appendChild(anyo);

        Element editorial = doc.createElement("editorial");
        editorial.setTextContent("DeBolsillo");
        libro.appendChild(editorial);


        try {
            xml.escribirDocumentAXmlFichero(doc,ruta);
            System.out.println("Ejercicio 1 terminado");
        } catch (TransformerException e) {
            throw new RuntimeException(e);
        }


    }

}
