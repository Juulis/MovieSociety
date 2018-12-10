package backend.entities;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class User {
    private String name;
    private String id;
    private List<Integer> groups;
    private String pw;
    private byte[] salt;

    public User() {
    }

    public User(String name, String id, List<Integer> groups, String pw) {
        this.name = name;
        this.id = id;
        this.groups = groups;
        this.pw = pw;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Integer> getGroups() {
        return groups;
    }

    public void addGroup(int groupID) {
        this.groups.add(groupID);
    }

    public void removeGroup(int groupID) {
        this.groups.remove((Integer) groupID);
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }
}
