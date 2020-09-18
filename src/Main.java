import getdata.GetSrData;

public class Main {

    public static void main(String[] args) {

        //        try {
        //            GetBGData.requestBGData();
        //        } catch (IOException e) {
        //            // TODO Auto-generated catch block
        //            e.printStackTrace();
        //        }

        try {
            GetSrData.requestSRData(
                "http://api.sr.se/api/v2/playlists/getplaylistbychannelid?id=164&startdatetime=2020-09-01&enddatetime=2020-09-03&size=500");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
