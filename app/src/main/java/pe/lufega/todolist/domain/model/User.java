package pe.lufega.todolist.domain.model;

/**
 * Created by DesarrolloF on 04/09/2017.
 */

public class User {

    private String Name;
    private String Mail;
    private String Password;
    private String Token;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
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
