package getdata;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import dao.DataAccess;
import dao.DataAccessImpl;
import domain.Song;
import parsing.SRParser;

public class GetSrData {

    public static void requestSRData(String url) throws Exception {

        //URL urlForGetRequest = new URL("https://jsonplaceholder.typicode.com/posts/1");
        DataAccess dao = new DataAccessImpl();
        URL urlForGetRequest = new URL(url);
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

            List<Song> songList = SRParser.parseXML(response.toString());
            dao.insertSong(songList);
        } else {
            System.out.println("GET NOT WORKED");
        }
    }
}
