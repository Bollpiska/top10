package parsing;

import java.io.ByteArrayInputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import dao.DataAccess;
import dao.DataAccessImpl;
import domain.Game;

public class XMLParser {

    //    Top10Service service = new Top10Service();

    public static void parseXML(String xml) {

        DataAccess da = new DataAccessImpl();

        System.out.println("hej");

        //   File xmlFile = new File(xml);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        try {
            dBuilder = dbFactory.newDocumentBuilder();

            Document doc = dBuilder.parse(new ByteArrayInputStream(xml.getBytes("UTF-8")));
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("boardgame");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                String name = null;
                double rating = 0;
                String description = null;
                String releaseDate = null;
                double weight = 0;
                int maxNumPlayers = 0;

                Node nNode = nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    name = eElement.getElementsByTagName("name").item(0).getTextContent();
                    description = eElement.getElementsByTagName("description").item(0).getTextContent();
                    releaseDate = eElement.getElementsByTagName("yearpublished").item(0).getTextContent();
                    maxNumPlayers =
                        Integer.parseInt(eElement.getElementsByTagName("maxplayers").item(0).getTextContent());

                    Element ratingElement = (Element) eElement.getElementsByTagName("ratings").item(0);
                    Element ranksElement = (Element) ratingElement.getElementsByTagName("ranks").item(0);
                    Element rankElement = (Element) ranksElement.getElementsByTagName("rank").item(0);
                    rating = Float.parseFloat(rankElement.getAttribute("bayesaverage"));

                }

                Game game = new Game(name, rating, description, releaseDate, maxNumPlayers);
                //                registerGame(game);
                da.insert();

                System.out.println("name: " + name + "\ndesc: " + description + "\nreleaseDate: " + releaseDate
                    + "\nrating: " + rating + "\nmaxplayers " + maxNumPlayers);

            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
