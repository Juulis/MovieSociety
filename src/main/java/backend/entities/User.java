package backend.entities;

import java.util.List;

public class User {
    private String name;
    private String id;
    private List<Integer> groups;

    public User() {
    }

    public User(String name, String id, List<Integer> groups) {
        this.name = name;
        this.id = id;
        this.groups = groups;
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
}
