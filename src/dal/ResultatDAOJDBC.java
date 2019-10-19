package dal;

import bo.Resultat;
import bo.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ResultatDAOJDBC extends DataAccessObjectJDBC<Resultat> {
    private static final String TOP_TEN_RESULT = "SELECT * from result order by points DESC,date_result DESC LIMIT 0,10";

    public ResultatDAOJDBC(String dbUrl, String dbLogin, String dbPwd) {
        super(dbUrl, dbLogin, dbPwd);
    }
    public List<Resultat> getTopTenResultat() throws SQLException {

        List<Resultat> resultats = new ArrayList<Resultat>();
        Resultat tempRes;
        UserDAOJDBC dao = ( UserDAOJDBC ) DAOFactory.getUserDAO();
        try (Connection connection = DriverManager.getConnection( dbUrl, dbLogin, dbPwd );
             PreparedStatement ps = connection.prepareStatement(TOP_TEN_RESULT) ) {
            try ( ResultSet rs = ps.executeQuery() ) {
                while ( rs.next() ) {
                    User curUser = dao.getUser( rs.getInt( "id_user" ));
                    tempRes = new Resultat();
                    tempRes.setId_result(rs.getInt( "id_result" ));
                    tempRes.setResult(rs.getInt( "points" ));
                    tempRes.setId_user(curUser);
                    tempRes.setDate_result(rs.getTimestamp( "date_result" ));
                    resultats.add(tempRes);
                }
            }
        }
        return resultats;
    }

    @Override
    public void create(Resultat objet) {

    }

    @Override
    public List<Resultat> findAll() {
        return null;
    }

}
