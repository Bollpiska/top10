package getdata;

public class Get500Numbers {

    public String getNumbers(int startnummer) {

        String games = startnummer + ",";
        int nummer = (startnummer + 499);

        while (startnummer < nummer) {
            startnummer++;
            games = games + startnummer + ",";

        }
        games = games + nummer;
        return games;
    }

}
