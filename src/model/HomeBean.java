package model;

import bo.Resultat;
import bo.User;
import dal.DAOFactory;
import dal.ResultatDAOJDBC;
import dal.UserDAOJDBC;

import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class HomeBean implements Serializable {
    public HomeBean() {}
    public List<Resultat> getTopTenResult(){
        ResultatDAOJDBC dao = ( ResultatDAOJDBC ) DAOFactory.getResultatsDAO();
        List<Resultat> resultats = null;
        try {
            resultats = dao.getTopTenResultat();

            if ( resultats != null ) {
                System.out.println("get top ten ok");
                return resultats;
            } else {
                System.out.println("result top ten null");
            }
        } catch ( SQLException e ) {
            System.out.println(e.getMessage());
        }
        return resultats;
    }
}
