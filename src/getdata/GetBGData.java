package getdata;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import parsing.XMLParser;

public class GetBGData {

    public static void main(String[] args) throws IOException {

        //URL urlForGetRequest = new URL("https://jsonplaceholder.typicode.com/posts/1");
        URL urlForGetRequest = new URL("https://www.boardgamegeek.com/xmlapi/boardgame/1020,1028?stats=1");
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

            XMLParser.parseXML(response.toString());
        } else {
            System.out.println("GET NOT WORKED");
        }
    }
}
