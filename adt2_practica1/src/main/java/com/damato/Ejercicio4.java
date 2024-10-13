package com.damato;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Ejercicio4 {
    static ArrayList<Alumne> alumnes;

    public static void main(String[] args) {
        alumnes = new ArrayList<>();
        File ruta = new File("adt2_practica1/src/main/resources/ejercicio4.xml");
        XmlCtrlDom xml = new XmlCtrlDom();
        try {
            //version1(xml, ruta);
            version2(xml, ruta);
            // version3(xml, ruta);


        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
//        } catch (XPathExpressionException e) {
//            throw new RuntimeException(e);
        }
    }

    private static void version3(XmlCtrlDom xml, File ruta) throws ParserConfigurationException, IOException, SAXException, XPathExpressionException {
        Document doc = xml.instanciarDocument(ruta);
        Element raiz = doc.getDocumentElement();
        String id = "";
        String nom = "";
        String cognom = "";
        String curs = "";
        int contador = 0;
        NodeList elementos = doc.getElementsByTagName("alumne");
        System.out.println(elementos.getLength());

        while (contador < elementos.getLength()) {
            id = elementos.item(contador).getAttributes().getNamedItem("id").getNodeValue();
            nom = doc.getElementsByTagName("nom").item(contador).getTextContent();
            cognom = doc.getElementsByTagName("cognom").item(contador).getTextContent();
            curs = doc.getElementsByTagName("curs").item(contador).getTextContent();

            Alumne a = new Alumne(id, nom, cognom, curs);
            System.out.println(a);
            alumnes.add(a);
            contador++;
        }

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
                for (int j = 0; j < elemento.getLength(); j++) {
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
                Alumne a = new Alumne(id, nom, cognom, curs);
                System.out.println(a.toString());
                alumnes.add(a);
            }
        }
    }

    private static void version1(XmlCtrlDom xml, File ruta) throws ParserConfigurationException, IOException, SAXException {

        // apuntamos al documento
        Document doc = xml.instanciarDocument(ruta);
        // obtenemos los alumnos del documento
        NodeList alumnesDoc = doc.getDocumentElement().getChildNodes();

        String id = "";
        String nom = "";
        String cognom = "";
        String curs = "";

        //recorremos cada alumno
        for (int i = 0; i < alumnesDoc.getLength(); i++) {
            NodeList alumne = alumnesDoc.item(i).getChildNodes();
            if (alumne instanceof Element) {
                // recorremos cad elemento de cada alumno
                id = ((Element) alumne).getAttribute("id");
                for (int j = 0; j < alumne.getLength(); j++) {
                    Node atributosALumno = alumne.item(j);
                    if (atributosALumno instanceof Element) {
                        if (atributosALumno.getNodeName().equals("nom")) nom = atributosALumno.getTextContent();
                        else if (atributosALumno.getNodeName().equals("cognom"))
                            cognom = atributosALumno.getTextContent();
                        else if (atributosALumno.getNodeName().equals("curs")) curs = atributosALumno.getTextContent();
                    }
                }
                Alumne alu = new Alumne(id, nom, cognom, curs);
                System.out.println(alu);
                alumnes.add(alu);
            }
        }
    }


    static class Alumne implements Comparable<Alumne> {

        private String id;
        private String nom;

        private String nota;

        private String cognom;
        private String curs;


        public Alumne(String id, String nom, String cognom, String curs) {
            this.id = id;
            this.nom = nom;
            this.cognom = cognom;
            this.curs = curs;
        }

        public Alumne(String id, String nom, String cognom, String nota, String curs) {
            this.id = id;
            this.nom = nom;
            this.cognom = cognom;
            this.nota = nota;
            this.curs = curs;
        }

        @Override
        public String toString() {
            return "Alumne{" + "id= " + id + '\'' +
                    "nom='" + nom + '\'' +
                    ", cognom='" + cognom + '\'' +
                    ", curs='" + curs + '\'' +
                    '}';
        }

        public String getNota() {
            return nota;
        }


        public String toString2() {
            return "Alumne{" +
                    "id='" + id + '\'' +
                    ", nom='" + nom + '\'' +
                    ", nota='" + nota + '\'' +
                    ", cognom='" + cognom + '\'' +
                    ", curs='" + curs + '\'' +
                    '}';
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getNom() {
            return nom;
        }

        public void setNom(String nom) {
            this.nom = nom;
        }

        public String getCognom() {
            return cognom;
        }

        public void setCognom(String cognom) {
            this.cognom = cognom;
        }

        public String getCurs() {
            return curs;
        }

        public void setCurs(String curs) {
            this.curs = curs;
        }

        @Override
        public int compareTo(Alumne o) {
            try {
                double thisNota = Double.parseDouble(this.nota);
                double oNota = Double.parseDouble(o.nota);

                //-1 this es menor
                // 1 this es mayor
                //ordena de menor a mayor
                return Double.compare(thisNota, oNota);
            } catch (NumberFormatException e) {
                System.out.println("Error al convertir la nota");
            }
            return 0;
        }
    }
}
