/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManejoDeArchivos;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Jason
 */
/**
 * Permite almacenar y leer en un xml, la configuracion de la empresa (clase
 * personalizada)
 *
 * @author Jason
 */
public class XMLConfiguracion {

    private static XMLConfiguracion xml;

    public static XMLConfiguracion getInstance() {
        if (xml == null) {

            xml = new XMLConfiguracion();
        }
        return xml;
    }

    /**
     * Crear archivo xml con informacion de configuracion
     *
     * @param nombreEmpresa
     * @param cedulaJuridica
     * @param dirrecion
     * @param telefono
     * @param ciudad
     * @param correo
     * @param comentarioInicial
     * @param comentarioFinal
     */
    public static void crearXML(String nombreEmpresa, String cedulaJuridica,
            String dirrecion, String telefono, String ciudad, String correo,
            String comentarioInicial, String comentarioFinal) {
        try {

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.
                    newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            // root 
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("Configuracion");
            doc.appendChild(rootElement);

            Element Empresa = doc.createElement("Empresa");
            rootElement.appendChild(Empresa);

            //Agregar Nombre a la empresa
            Element NombreEmpresa = doc.createElement("NombreEmpresa");
            NombreEmpresa.appendChild(doc.createTextNode(nombreEmpresa));
            Empresa.appendChild(NombreEmpresa);

            // Agregar cedula juridica
            Element CedulaJuridica = doc.createElement("CedulaJuridica");
            CedulaJuridica.appendChild(doc.createTextNode(cedulaJuridica));
            Empresa.appendChild(CedulaJuridica);

            // Agregar Direccion
            Element nickname = doc.createElement("Dirrecion");
            nickname.appendChild(doc.createTextNode(dirrecion));
            Empresa.appendChild(nickname);

            // Agregar telefono
            Element Telefono = doc.createElement("Telefono");
            Telefono.appendChild(doc.createTextNode(telefono));
            Empresa.appendChild(Telefono);

            // Agregar correo
            Element Correo = doc.createElement("Correo");
            Correo.appendChild(doc.createTextNode(correo));
            Empresa.appendChild(Correo);

            //Agregar cuidad
            Element Ciudad = doc.createElement("Ciudad");
            Ciudad.appendChild(doc.createTextNode(ciudad));
            Empresa.appendChild(Ciudad);

            // Agregar informacion de factura
            Element Factura = doc.createElement("Factura");
            rootElement.appendChild(Factura);

            //Agregar comentario Inicial de la factura
            Element ComentarioIni = doc.createElement("ComentarioInicial");
            ComentarioIni.appendChild(doc.createTextNode(comentarioInicial));
            Factura.appendChild(ComentarioIni);

            Element ComentarioFin = doc.createElement("ComentarioFinal");
            ComentarioFin.appendChild(doc.createTextNode(comentarioFinal));
            Factura.appendChild(ComentarioFin);

            // escribir los datos en el documento xml
            TransformerFactory transformerFactory = TransformerFactory.
                    newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("Configuracion.xml"));

            transformer.transform(source, result);

        } catch (ParserConfigurationException | TransformerException pce) {
            System.out.println("Error con el archivo xml");
        }
    }

    /**
     * retorna un string[] con la informacion de la empresa
     *
     * @return
     */
    public static String[] leerInfoEmpresaXML() {
        String[] infoEmpresa = new String[6];
        try {
            File fXmlFile = new File("Configuracion.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.
                    newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("Empresa");

            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;

                    infoEmpresa[0] = eElement.
                            getElementsByTagName("NombreEmpresa").item(0).
                            getTextContent();
                    infoEmpresa[1] = eElement.
                            getElementsByTagName("Dirrecion").
                            item(0).getTextContent();
                    infoEmpresa[2] = eElement.getElementsByTagName("Ciudad").
                            item(0).getTextContent();
                    infoEmpresa[3] = "Cedula Juridica " + eElement.
                            getElementsByTagName("CedulaJuridica").
                            item(0).getTextContent();
                    infoEmpresa[4] = "Telefono " + eElement.getElementsByTagName("Telefono").
                            item(0).getTextContent();
                    infoEmpresa[5] = "Correo " + eElement.getElementsByTagName("Correo").
                            item(0).getTextContent();

                }
            }

        } catch (Exception e) {

        }

        return infoEmpresa;
    }
/**
 * Retorna un String[] con los comentarios inicial y final de factura 
 * respectivamente
 * @return 
 */
    public static String[] leerInfoParaFactura() {
        String[] comentariosFact = new String[2];
        try {

            File fXmlFile = new File("Configuracion.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            doc.getDocumentElement().normalize();
            NodeList nListFac = doc.getElementsByTagName("Factura");
            for (int temp = 0; temp < nListFac.getLength(); temp++) {

                Node nNode = nListFac.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;

                    comentariosFact[0] = eElement.
                            getElementsByTagName("ComentarioInicial").item(0).
                            getTextContent();
                    comentariosFact[1] = eElement.
                            getElementsByTagName("ComentarioFinal").
                            item(0).getTextContent();

                }
            }
        } catch (IOException | ParserConfigurationException | DOMException | SAXException e) {
        }
        return comentariosFact;
    }
}
