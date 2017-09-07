package pe.lufega.todolist.data.entity;

import io.realm.RealmObject;

/**
 * Created by DesarrolloF on 04/09/2017.
 */

public class UserEntity extends RealmObject {

    private String Name;
    private String Mail;
    private String Password;
    private String Token;

    public String getName() {
        return Name;
    }

    public void setName(String user) {
        Name = user;
    }

    public String getMail() {
        return Mail;
    }

    public void setMail(String mail) {
        Mail = mail;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getToken() {
        return Token;
    }

    public void setToken(String token) {
        Token = token;
    }
}
