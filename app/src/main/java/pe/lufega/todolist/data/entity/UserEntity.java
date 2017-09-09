package pe.lufega.todolist.data.entity;

import io.realm.RealmObject;

/**
 * Created by DesarrolloF on 04/09/2017.
 */

public class UserEntity extends RealmObject {

    private String email;
    private String password;
    private String name;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
