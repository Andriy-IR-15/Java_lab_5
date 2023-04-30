package ua.lviv.iot;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StoreLocations {

    public static ArrayList<String> findLocations(String filePath) throws IOException {
        ArrayList<String> locations = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line = reader.readLine();
        while (line != null) {
            Pattern shop = Pattern.compile("\"[А-я].*?\"");
            Pattern pattern = Pattern.compile("N \\d{1,2}\\.\\d{2}'\\d{2}\" E \\d{1,2}\\.\\d{2}'\\d{2}\"");
            Matcher matcherShop = shop.matcher(line);
            Matcher matcher = pattern.matcher(line);
            while (matcherShop.find() && matcher.find()) {
                locations.add(matcherShop.group().concat(" " + matcher.group()));
            }
            line = reader.readLine();
        }
        reader.close();
        return locations;
    }

    public static void main(String[] args) {
        try {
            ArrayList<String> locations = findLocations("stores.txt");
            for (String location : locations) {
                System.out.println(location);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
    }
}
