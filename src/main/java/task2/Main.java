package task2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    
    public static void main(String[] args) throws Exception {

        String request = "src/main/java/task2/json.txt";

        String result = new String(Files.readAllBytes(Paths.get(request)));
        System.out.println(result);

        Gson gson = new GsonBuilder().create();
        Card json = (Card) gson.fromJson(result, Card.class);

        System.out.println(json);

    }

}