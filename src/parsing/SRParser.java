package parsing;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import dao.DataAccess;
import dao.DataAccessImpl;
import domain.Song;

public class SRParser {

    public static List<Song> parseXML(String xml) {

        DataAccess da = new DataAccessImpl();

        System.out.println("hej");

        //   File xmlFile = new File(xml);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        List<Song> songList = new ArrayList<Song>();

        try {
            dBuilder = dbFactory.newDocumentBuilder();

            Document doc = dBuilder.parse(new ByteArrayInputStream(xml.getBytes("UTF-8")));
            doc.getDocumentElement().normalize();
            //            NodeList nList = doc.getElementsByTagName("boardgame");

            //  Element node = (Element) doc.getElementsByTagName("song");

            NodeList nList = doc.getElementsByTagName("song");
            System.out.println(nList.getLength());

            // Av någon anledning får vi varannan null, så därav knasig loop!
            for (int temp = 1; temp < nList.getLength(); temp += 2) {

                String title = null;
                String artist = null;

                Node nNode = nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    title = eElement.getElementsByTagName("title").item(0).getTextContent();

                    artist = eElement.getElementsByTagName("artist").item(0).getTextContent();

                }

                Song song = new Song(title, artist);
                songList.add(song);

                System.out.println("title: " + title + "\nartist: " + artist);

            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return songList;

    }

}
