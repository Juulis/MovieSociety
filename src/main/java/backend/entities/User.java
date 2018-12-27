package backend.entities;

import lombok.Data;

import java.util.List;
import javax.persistence.Entity;

@Data
@Entity
public class User {
    private String name;
    private List<Integer> groups;
    private String pw;
    private String mail;

    public User() {
    }

    public User(String name, String pw) {
        this.name = name;
        this.pw = pw;
    }

    public User(String name, List<Integer> groups, String pw, String mail) {
        this.name = name;
        this.groups = groups;
        this.pw = pw;
        this.mail = mail;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
