package backend.controllers;

import backend.entities.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;

@RestController
public class UserController {
    private byte[] salt = "petter".getBytes();

    public UserController() {
    }

    @RequestMapping(value = "/adduser")
    public User adduser(@RequestParam("name") String name, @RequestParam("id") String id, @RequestParam(value = "pw", defaultValue = "1337") String pw) {
        User user = new User(name, id, null, createPw(pw));
        String dbPath = "users/" + user.getId();
        DatabaseController.getInstance().sendToDb(user, dbPath);
        return user;
    }

    public String createPw(String pw){
        KeySpec spec = new PBEKeySpec(pw.toCharArray(), salt, 65536, 512);
        SecretKeyFactory f = null;
        try {
            f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        byte[] hash = new byte[0];
        try {
            hash = f.generateSecret(spec).getEncoded();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }
        Base64.Encoder enc = Base64.getEncoder();
        System.out.printf("salt: %s%n", enc.encodeToString(salt));
        System.out.printf("hash: %s%n", enc.encodeToString(hash));
        System.out.println();

        return enc.encodeToString(hash);
    }

}