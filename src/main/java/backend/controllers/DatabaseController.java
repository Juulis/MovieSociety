package backend.controllers;

import backend.entities.User;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

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
        System.out.println(dbrefString);
        dbref.setValueAsync(obj);
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
