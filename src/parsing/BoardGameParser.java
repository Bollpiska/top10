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
import domain.Game;

public class BoardGameParser {

    //    Top10Service service = new Top10Service();

    public static List<Game> parseXML(String xml) {

        DataAccess da = new DataAccessImpl();

        System.out.println("hej");

        //   File xmlFile = new File(xml);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        List<Game> gameList = new ArrayList<Game>();

        try {
            dBuilder = dbFactory.newDocumentBuilder();

            Document doc = dBuilder.parse(new ByteArrayInputStream(xml.getBytes("UTF-8")));
            doc.getDocumentElement().normalize();
            //            NodeList nList = doc.getElementsByTagName("boardgame");

            Element node = (Element) doc.getFirstChild();

            NodeList nList = node.getChildNodes();
            System.out.println(nList.getLength());

            // Av någon anledning får vi varannan null, så därav knasig loop!
            for (int temp = 1; temp < nList.getLength(); temp += 2) {
                String ratingString = null;
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

                    //                    ratingString = rankElement.getAttribute("bayesaverage");
                    //                    if (ratingString == "Not Ranked") {
                    //                        rating = 0;
                    //                    } else {
                    //                        rating = Float.parseFloat(ratingString);

                    try {
                        rating = Float.parseFloat(rankElement.getAttribute("bayesaverage"));
                    } catch (Exception c) {
                        rating = 0;
                    }

                }

                Game game = new Game(name, rating, description, releaseDate, maxNumPlayers);
                gameList.add(game);
                //                registerGame(game);
                //da.insert();

                System.out.println("name: " + name + "\ndesc: " + description + "\nreleaseDate: " + releaseDate
                    + "\nrating: " + rating + "\nmaxplayers " + maxNumPlayers);

            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return gameList;

    }

}
