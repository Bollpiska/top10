package getdata;

public class Get500Numbers {

    public String getNumbers() {

        String games = "1,";
        int nummer = 2;

        while (nummer < 500) {
            games = games + nummer + ",";
            nummer++;
        }
        games = games + "500";
        return games;
    }

}
