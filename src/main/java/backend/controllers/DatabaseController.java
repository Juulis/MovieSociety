package backend.controllers;

import backend.entities.Movie;
import backend.entities.User;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.*;
import org.springframework.web.client.RestTemplate;

import java.io.FileInputStream;
import java.io.IOException;

public class DatabaseController {
    private static DatabaseController ourInstance = new DatabaseController();

    public static DatabaseController getInstance() {
        return ourInstance;
    }

    private FirebaseDatabase database;

    private DatabaseReference ref;

    private DatabaseController() {
        initializeFirebase();
    }

    public void sendToDb(Object obj, String dbrefString) {
        DatabaseReference dbref = ref.child(dbrefString);
        dbref.setValueAsync(obj);
    }


    public Movie[] fetchMovies(String search) {
        RestTemplate restTemplate = new RestTemplate();
        String call = String.format("https://moviesociety-88142.firebaseio.com/search/%s.json", search);
        Movie[] response = restTemplate.getForObject(call, Movie[].class);
        if (response != null) {
            return response;
        }
        return null;
    }

    public String fetchPw(String username) {
        RestTemplate restTemplate = new RestTemplate();
        String call = String.format("https://moviesociety-88142.firebaseio.com/users/%s.json", username);
        User userResponse = restTemplate.getForObject(call, User.class);
        if (userResponse == null) {
            return null;
        }

        return userResponse.getPw();
    }

    private void initializeFirebase() {

        try {

            FileInputStream serviceAccount =
                    new FileInputStream("E:\\Downloads\\moviesociety-88142-firebase-adminsdk-0cfn2-97d13ab429.json");

            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://moviesociety-88142.firebaseio.com")
                    .build();

            FirebaseApp.initializeApp(options);

        } catch (IOException e) {
            System.out.println("can't connect to db");
        }
        database = FirebaseDatabase.getInstance();
        ref = database.getReference();

    }
}
