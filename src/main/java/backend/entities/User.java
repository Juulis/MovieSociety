package backend.entities;

import java.util.List;

public class User {
    private String name;
    private List<Integer> groups;
    private String pw;
    private byte[] salt;

    public User() {
    }

    public User(String name, List<Integer> groups, String pw) {
        this.name = name;
        this.groups = groups;
        this.pw = pw;
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
}
