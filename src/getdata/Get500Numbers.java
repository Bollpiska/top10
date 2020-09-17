package getdata;

public class Get500Numbers {

    public static String getNumbers(int startnummer) {

        String games = startnummer + ",";
        int nummer = (startnummer + 1000);

        while (startnummer < nummer) {
            startnummer++;
            games = games + startnummer + ",";

        }
        games = games + (nummer + 1);
        return games;
    }

}
