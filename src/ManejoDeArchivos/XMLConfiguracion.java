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
     * @param Usuario
     * @param rutaImagen
     * @param PosXImagen
     * @param PosYImagen
     * @param PosYNombreEmpresa
     * @param PosXNombreEmpresa
     */
    public static void crearXML(String nombreEmpresa, String cedulaJuridica,
            String dirrecion, String telefono, String ciudad, String correo,
            String comentarioInicial, String comentarioFinal, String Usuario,
            String rutaImagen,String posXImagen,String posYImagen,String posXNombreEmpresa,String posYNombreEmpresa) {
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

            // Agregar informacion de Usuario Actual
            Element UsuarioAct = doc.createElement("Usuario");
            rootElement.appendChild(UsuarioAct);

            //Agregar Usuario Actual
            Element UsuarioActual = doc.createElement("UsuarioActual");
            UsuarioActual.appendChild(doc.createTextNode(Usuario));
            UsuarioAct.appendChild(UsuarioActual);

            // Agregar informacion de Usuario Actual
            Element Imagen = doc.createElement("Imagen");
            rootElement.appendChild(Imagen);

            //Agregar ruta Imagen
            Element RutaImagen = doc.createElement("RutaImagen");
            RutaImagen.appendChild(doc.createTextNode(rutaImagen));
            Imagen.appendChild(RutaImagen);
            
            
            ////////*****************modificaciones para josehp/********
            //Agregar posixion x de Imagen
            Element PosXImagen = doc.createElement("PosXImagen");
            PosXImagen .appendChild(doc.createTextNode(posXImagen));
            Imagen.appendChild(PosXImagen);
            //*********************************************************
           
            //Agregar posixion y de Imagen
            Element PosYImagen = doc.createElement("PosYImagen");
            PosYImagen .appendChild(doc.createTextNode(posYImagen));
            Imagen.appendChild(PosYImagen);
            
            //Agregar posixion x de nombre empresa
            Element PosXNombreEmpresa = doc.createElement("PosXNombreEmpresa");
            PosXNombreEmpresa .appendChild(doc.createTextNode(posXNombreEmpresa));
            Imagen.appendChild(PosXNombreEmpresa);
            //*********************************************************
           
            //Agregar posicion y de nombre de la empresa
            Element PosYNombreEmpresa = doc.createElement("PosYNombreEmpresa");
           PosYNombreEmpresa.appendChild(doc.createTextNode(posYNombreEmpresa));
            Imagen.appendChild(PosYNombreEmpresa);
            //*********************************************************
            
            // escribir los datos en el documento xml
            TransformerFactory transformerFactory = TransformerFactory.
                    newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result
                    = new StreamResult(new File("Configuracion.xml"));

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
    public String[] leerInfoEmpresaXML() {
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
                    infoEmpresa[3] = eElement.
                            getElementsByTagName("CedulaJuridica").
                            item(0).getTextContent();
                    infoEmpresa[4] = eElement.
                            getElementsByTagName("Telefono").
                            item(0).getTextContent();
                    infoEmpresa[5] = eElement.
                            getElementsByTagName("Correo").
                            item(0).getTextContent();

                }
            }
            return infoEmpresa;

        } catch (ParserConfigurationException | SAXException | IOException |
                DOMException e) {

        }

        return null;
    }

    /**
     * Retorna un String[] con los comentarios inicial y final de factura
     * respectivamente
     *
     * @return
     */
    public String[] leerInfoParaFactura() {
        String[] comentariosFact = new String[2];
        comentariosFact[0] = obtenerValorDeElemeto("Factura",
                "ComentarioInicial");
        comentariosFact[1] = obtenerValorDeElemeto("Factura",
                "ComentarioFinal");
        return comentariosFact;
    }

    /**
     * Obtener el nombre la empresa y el telefono.
     *
     * @return
     */
    public String[] NombreTelefonoEmpresa() {
        String[] infoEmpresa = new String[2];
        infoEmpresa[0] = obtenerValorDeElemeto("Empresa",
                "NombreEmpresa");
        infoEmpresa[1] = obtenerValorDeElemeto("Empresa",
                "Telefono");

        return infoEmpresa;
    }

    /**
     * Permite obtener el usuario actual
     *
     * @return
     */
    public String ObtenerUsuario() {
        return obtenerValorDeElemeto("Usuario", "UsuarioActual");
    }

    /**
     * Permite actualizar el elemento Usuario Actual.
     *
     * @param nuevoUsuario
     */
    public void establecerUsuario(String nuevoUsuario) {
        actualizarContenidoElemento("Usuario", "UsuarioActual", nuevoUsuario);
    }

    /**
     * obtener ruta de la imagen
     *
     * @return
     */
    public String obtenerRutaImagen() {
        return obtenerValorDeElemeto("Imagen", "RutaImagen");
    }
    public String obtenerPosXImagen() {
        return obtenerValorDeElemeto("Imagen", "PosXImagen");
    }
    public String obtenerPosYImagen() {
        return obtenerValorDeElemeto("Imagen", "PosYImagen");
    }
    public String obtenerPosXNombreEmpresa() {
        return obtenerValorDeElemeto("Imagen", "PosXNombreEmpresa");
    }
    public String obtenerPosYNombreEmpresa() {
        return obtenerValorDeElemeto("Imagen", "PosYNombreEmpresa");
    }

    /**
     * Actualizar el contenido de un elemento
     *
     * @param elementoPadre
     * @param elemento
     * @param nuevoValor
     */
    public void actualizarContenidoElemento(String elementoPadre,
            String elemento, String nuevoValor) {
        String filePath = "Configuracion.xml";
        File xmlFile = new File(filePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            NodeList elementPadre = doc.getElementsByTagName(elementoPadre);

            for (int temp = 0; temp < elementPadre.getLength(); temp++) {

                Node nNode = elementPadre.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;

                    eElement.getElementsByTagName(elemento).item(0).
                            setTextContent(nuevoValor);
                }
            }

            //escribir las actualizaciones en xml
            doc.getDocumentElement().normalize();
            TransformerFactory transformerFactory = TransformerFactory.
                    newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(
                    new File("Configuracion.xml"));
            transformer.transform(source, result);

        } catch (SAXException | ParserConfigurationException | IOException |
                TransformerException e1) {
            System.out.println("Error al actualizar xml");
        }

    }

    /**
     * Actualizar Ruta de la imagen.
     *
     * @param nuevoValor
     */
    public void establecerRutaImagen(String nuevoValor) {
        actualizarContenidoElemento("Imagen", "RutaImagen", nuevoValor);
    }
    public void establecerPosXImagen(String nuevoValor) {
        actualizarContenidoElemento("Imagen", "PosXImagen", nuevoValor);
    }
    public void establecerPosYImagen(String nuevoValor) {
        actualizarContenidoElemento("Imagen", "PosYImagen", nuevoValor);
    }
    public void establecerPosXNombreEmpresa(String nuevoValor) {
        actualizarContenidoElemento("Imagen", "PosXNombreEmpresa", nuevoValor);
    }
    public void establecerPosYNombreEmpresa(String nuevoValor) {
        actualizarContenidoElemento("Imagen", "PosYNombreEmpresa", nuevoValor);
    }

    /**
     * Permite obtener el valor de un elemento.
     *
     * @param elementoPadre
     * @param elemento
     * @return
     */
    private String obtenerValorDeElemeto(String elementoPadre, String elemento) {
        String valor = "";
        try {
            File fXmlFile = new File("Configuracion.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.
                    newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName(elementoPadre);

            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;

                    valor = eElement.
                            getElementsByTagName(elemento).item(0).
                            getTextContent();
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException |
                DOMException e) {
        }
        return valor;
    }
}
