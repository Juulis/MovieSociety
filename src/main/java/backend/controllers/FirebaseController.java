package backend.controllers;

import backend.entities.User;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class FirebaseController {

    private FirebaseDatabase database;
    private DatabaseReference ref;

    public FirebaseController() {
        initializeFirebase();
        List<Integer> tempgroups = new ArrayList<>();
        tempgroups.add(1);
        tempgroups.add(3);
        tempgroups.add(5);
        addUser(new User("Juulis", "1337", tempgroups));
    }

    public void addUser(User user) {
        DatabaseReference usersRef = ref.child("users");
        usersRef.child(user.getId()).setValueAsync(user);
            System.out.println("added user");
    }

    public void initializeFirebase() {

        try {

            FileInputStream serviceAccount =
                    new FileInputStream("E:\\Downloads\\moviesociety-88142-firebase-adminsdk-0cfn2-97d13ab429.json");

            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://moviesociety-88142.firebaseio.com")
                    .build();

            FirebaseApp.initializeApp(options);
            System.out.println("connected to firebase");

        } catch (Exception e) {
            System.out.println("can't connect to db");
        }
        database = FirebaseDatabase.getInstance();
        ref = database.getReference();

    }
}