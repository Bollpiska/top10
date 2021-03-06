package getdata;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import dao.DataAccess;
import dao.DataAccessImpl;
import domain.Game;
import parsing.BoardGameParser;

public class GetBGData {

    public static void requestBGData() throws IOException {

        String numbers = Get500Numbers.getNumbers(531);
        System.out.println(numbers);

        //URL urlForGetRequest = new URL("https://jsonplaceholder.typicode.com/posts/1");
        DataAccess dao = new DataAccessImpl();
        URL urlForGetRequest = new URL("https://www.boardgamegeek.com/xmlapi/boardgame/" + numbers + "?stats=1");
        String readLine = null;
        HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
        conection.setRequestMethod("GET");
        //  conection.setRequestProperty("userId", "a1bcdef"); // set userId its a sample here
        int responseCode = conection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(conection.getInputStream()));
            StringBuffer response = new StringBuffer();
            while ((readLine = in.readLine()) != null) {
                response.append(readLine);
                response.append("\n");
            }
            in.close();
            // print result
            System.out.println("XML String Result " + response.toString());
            //GetAndPost.POSTRequest(response.toString());

            List<Game> gameList = BoardGameParser.parseXML(response.toString());
            dao.insertGame(gameList);
        } else {
            System.out.println("GET NOT WORKED");
        }
    }
}
