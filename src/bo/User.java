package bo;

import java.io.Serializable;

public class User implements Serializable {
    private  int id_user;



    private String login;
    private String password;
    private int topResult;

    public User() {}

    public User(int id_user, String login, String password, int topResult) {
        this.id_user = id_user;
        this.login = login;
        this.password = password;
        this.topResult = topResult;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin( String login ) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword( String password ) {
        this.password = password;
    }

    public int getTopResult() {
        return topResult;
    }

    public void setTopResult( int topResult ) {
        this.topResult = topResult;
    }
}
