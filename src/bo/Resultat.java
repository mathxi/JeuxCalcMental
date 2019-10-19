package bo;

import java.util.Date;

public class Resultat {
    private int id_result;
    private int result;
    private Date date_result;
    private User id_user;

    public Resultat() {
    }

    public Resultat(int id_result, int result, Date date_result, User id_user) {
        this.id_result = id_result;
        this.result = result;
        this.date_result = date_result;
        this.id_user = id_user;
    }

    public int getId_result() {
        return id_result;
    }

    public void setId_result(int id_result) {
        this.id_result = id_result;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public Date getDate_result() {
        return date_result;
    }

    public void setDate_result(Date date_result) {
        this.date_result = date_result;
    }

    public User getId_user() {
        return id_user;
    }

    public void setId_user(User id_user) {
        this.id_user = id_user;
    }
}
