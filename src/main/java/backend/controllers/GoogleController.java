package backend.controllers;

import com.google.api.services.sqladmin.SQLAdmin;
import org.springframework.web.bind.annotation.RestController;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.services.sqladmin.SQLAdminScopes;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;

@RestController
public class GoogleController {



    GoogleCredential credential;

    {
        try {
            credential = GoogleCredential.fromStream(new FileInputStream("E:\\Downloads\\moviesociety-88142-39bee464caf9.json"))
                        .createScoped(Collections.singleton(SQLAdminScopes.SQLSERVICE_ADMIN));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}

