package utils;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class JsonUtils {
    private List<Patient> patientList = new ArrayList<>();

    private final Gson gson = new GsonBuilder()
            .registerTypeAdapter(LocalDate.class,
                    (JsonDeserializer<LocalDate>) (json, typeOfT, context) ->
                            LocalDate.parse(json.getAsString()))
            .registerTypeAdapter(LocalDateTime.class,
                    (JsonDeserializer<LocalDateTime>) (json, typeOfT, context) ->
                            LocalDateTime.parse(json.getAsString()))
            .registerTypeAdapter(LocalDate.class,
                    (JsonSerializer<LocalDate>) (src, typeOfSrc, context) ->
                            new JsonPrimitive(src.toString()))
            .registerTypeAdapter(LocalDateTime.class,
                    (JsonSerializer<LocalDateTime>) (src, typeOfSrc, context) ->
                            new JsonPrimitive(src.toString()))
            .excludeFieldsWithoutExposeAnnotation()
            .setPrettyPrinting()
            .create();


    private final String dir = "data/json/";

    public List<Patient> readPatients() throws FileNotFoundException {
        JsonReader reader = new JsonReader(new FileReader(dir + "patients.json"));

        Type listType = new TypeToken<List<Patient>>(){}.getType();
        List<Patient> patients = gson.fromJson(reader, listType);
        patientList = patients;
        return patients;
    }

    public void addPatientToJson(Patient patient) throws IOException {
        File file = new File(dir + "patients.json");
        if (!file.exists()) {
            file.createNewFile();
        }

        List<Patient> patients = new ArrayList<>();
        if (file.length() > 0) {
            try (FileReader reader = new FileReader(file)) {
                Type patientListType = new TypeToken<List<Patient>>(){}.getType();
                patients = gson.fromJson(reader, patientListType);
                if (patients == null) {
                    patients = new ArrayList<>();
                }
            }
        }

        patients.add(patient);

        try (FileWriter writer = new FileWriter(file)) {
            gson.toJson(patients, writer);
        }
    }

    public boolean removePatientByName(String fullName) throws IOException {
        if (fullName == null || fullName.trim().isEmpty()) {
            return false;
        }

        File file = new File(dir + "patients.json");
        if (!file.exists() || file.length() == 0) {
            return false;
        }

        List<Patient> patients;
        try (FileReader reader = new FileReader(file)) {
            Type patientListType = new TypeToken<List<Patient>>(){}.getType();
            patients = gson.fromJson(reader, patientListType);
        }

        if (patients == null || patients.isEmpty()) {
            return false;
        }

        int initialSize = patients.size();
        patients.removeIf(p -> p != null &&
                p.getFullName() != null &&
                p.getFullName().equalsIgnoreCase(fullName.trim()));

        if (patients.size() < initialSize) {
            try (FileWriter writer = new FileWriter(file)) {
                gson.toJson(patients, writer);
            }
            return true;
        }
        return false;
    }

//    public List<User> readUsers() throws FileNotFoundException {
//        JsonReader reader = new JsonReader(new FileReader(dir + "users.json"));
//
//        Type listType = new TypeToken<List<User>>(){}.getType();
//        List<User> users = gson.fromJson(reader, listType);
//        return users;
//    }

//    public void addUsersToJson(List<User> users) throws FileNotFoundException {
//        try{
//            FileWriter writer = new FileWriter(dir + "users.json");
//            String write = gson.toJson(users);
//            writer.write(write);
//            writer.flush();
//            writer.close();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
