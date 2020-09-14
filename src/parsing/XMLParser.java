package parsing;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class XMLParser {

    public static void parseXML(String xml) {

        File xmlFile = new File(xml);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(xmlFile);
        doc.getDocumentElement().normalize();
        NodeList nList = doc.getElementsByTagName("boardgame");

        for (int temp; temp < nList.getLength(); temp++) {
            String name = null;
            double rating = 0;
            String description = null;
            String releaseDate = null;
            double weight = 0;
            int maxNumPlayers = 0;

            if
        }

    }

}
