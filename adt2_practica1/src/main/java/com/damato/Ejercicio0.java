package com.damato;
//generea el arbol

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.IOException;

public class Ejercicio0 {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, XPathExpressionException {
        XmlCtrlDom xml = new XmlCtrlDom();
        File ruta = new File("adt2_practica1/src/main/resources/ejercicio1.xml");

        if (!ruta.exists()) {
            iniciarArbol(xml, ruta);
        } else if (ruta.exists()) {
            System.out.println("El documento ya existe");
        } else System.out.printf("El documento %s no pudo ser creado", ruta);


        Element compra = (Element) XPathFactory.newInstance().newXPath().evaluate("/libros/compra", DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(ruta),XPathConstants.NODE);
        if(compra==null)
        modificarArbol(xml, ruta);
        else System.out.println("Metodo ya usado");

    }

    private static void modificarArbol(XmlCtrlDom xml, File ruta) {
        try {
            Document doc = xml.instanciarDocument(ruta);

            XPath xpath = XPathFactory.newInstance().newXPath();
            Element prestamo = (Element) xpath.evaluate("//prestamo", doc, XPathConstants.NODE);

            Element libro = doc.createElement("libro");
            libro.setAttribute("isbn", "8422667657");

            prestamo.appendChild(libro);

            Element titulo = doc.createElement("titulo");
            titulo.setTextContent("Qumran");
            libro.appendChild(titulo);

            Element autor = doc.createElement("autor");
            autor.setTextContent("Eliette Abecasis");
            libro.appendChild(autor);

            Element anyo = doc.createElement("anyo");
            anyo.setTextContent("1997");
            libro.appendChild(anyo);

            Element editorial = doc.createElement("editorial");
            editorial.setTextContent("Ediciones B");
            libro.appendChild(editorial);


            ////////       LIBRO 2        ////////////
            Element libro2 = doc.createElement("libro");
            libro2.setAttribute("isbn", "AAAAAAAAAA");

            prestamo.appendChild(libro2);

            Element titulo2 = doc.createElement("titulo");
            titulo2.setTextContent("MI TITULO");
            libro2.appendChild(titulo2);

            Element autor2 = doc.createElement("autor");
            autor2.setTextContent("David");
            libro2.appendChild(autor2);

            Element anyo2 = doc.createElement("anyo");
            anyo2.setTextContent("2024");
            libro2.appendChild(anyo2);

            Element editorial2 = doc.createElement("editorial");
            editorial2.setTextContent("Ediciones Z");
            libro2.appendChild(editorial2);


            //por dom
            NodeList ventas =  doc.getElementsByTagName("venta");
            Element venta= (Element) ventas.item(0);

            ////////       LIBRO 3       ////////////
            Element libro3 = doc.createElement("libro");
            libro3.setAttribute("isbn", "84675069x");

            venta.appendChild(libro3);

            Element titulo3 = doc.createElement("titulo");
            titulo3.setTextContent("Memoria de Idun");
            libro3.appendChild(titulo3);

            Element autor3 = doc.createElement("autor");
            autor3.setTextContent("Laura Gallego garcia");
            libro3.appendChild(autor3);

            Element anyo3 = doc.createElement("anyo");
            anyo3.setTextContent("2005");
            libro3.appendChild(anyo3);

            Element editorial3 = doc.createElement("editorial");
            editorial3.setTextContent("Ediciones SM");
            libro3.appendChild(editorial3);

            /// añadir compra
            Element libros = (Element) XPathFactory.newInstance().newXPath().evaluate("//libros",doc,XPathConstants.NODE);

            Element compra = doc.createElement("compra");
            libros.appendChild(compra);


            xml.escribirDocumentAXmlFichero(doc,ruta);
            System.out.println("Proceso terminado");


        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        } catch (XPathExpressionException e) {
            throw new RuntimeException(e);
        } catch (TransformerException e) {
            throw new RuntimeException(e);
        }
    }

    private static void iniciarArbol(XmlCtrlDom xml, File ruta) {
        try {
            Document doc = xml.instanciarDocument();

            Element libros = doc.createElement("libros");
            doc.appendChild(libros);

            Element prestamo = doc.createElement("prestamo");
            libros.appendChild(prestamo);

            Element venta = doc.createElement("venta");
            libros.appendChild(venta);

            Element libro = doc.createElement("libro");
            prestamo.appendChild(libro);

            libro.setAttribute("ibn", "978848652202");

            Element titulo = doc.createElement("titulo");
            titulo.setTextContent("El Ocho");
            libro.appendChild(titulo);

            Element autor = doc.createElement("autor");
            autor.setTextContent("Katherine Neville");
            libro.appendChild(autor);

            Element anyo = doc.createElement("anyo");
            anyo.setTextContent("1988");
            libro.appendChild(anyo);

            Element editorial = doc.createElement("editorial");
            editorial.setTextContent("Ballantine Books");
            libro.appendChild(editorial);


            xml.escribirDocumentAXmlFichero(doc, ruta);
            System.out.println("Documento creado");


        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (TransformerException e) {
            throw new RuntimeException(e);
        }
    }

}
