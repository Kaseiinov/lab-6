package utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import server.models.Candidate;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class FileUtils {
    private static Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static Path PATH = Paths.get("data/json/candidates.json");

    public static List<Candidate> readFile(){
        List<Candidate> candidates = new ArrayList<>();

        try{
            String str = Files.readString(PATH);
            Candidate[] candidatesArray = GSON.fromJson(str, Candidate[].class);

            if (candidatesArray != null) {
                candidates = new ArrayList<>(List.of(candidatesArray));
                AtomicInteger counter = new AtomicInteger(1);
                candidates.forEach(candidate -> candidate.setId(String.valueOf(counter.getAndIncrement())));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return  candidates;
    }

    public static void writeFile(List<Candidate> candidates) {
        String newGson = GSON.toJson(candidates);

        try{
            Files.writeString(PATH, newGson);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
