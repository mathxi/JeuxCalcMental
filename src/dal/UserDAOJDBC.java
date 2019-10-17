package dal;

import bo.User;

import java.sql.*;
import java.util.List;

public class UserDAOJDBC extends DataAccessObjectJDBC<User> {

    private static final String AUTHENT_QUERY = "SELECT * FROM user WHERE login = ? AND password = ?";

    public UserDAOJDBC( String dbUrl, String dbLogin, String dbPwd ) {
        super( dbUrl, dbLogin, dbPwd );
    }

    @Override
    public void create( User objet ) {

    }

    @Override
    public List<User> findAll() {
        return null;
    }

    public User authenticate( String login, String password ) throws SQLException {

        User user = null;
        try ( Connection connection = DriverManager.getConnection( dbUrl, dbLogin, dbPwd );
              PreparedStatement ps = connection.prepareStatement(AUTHENT_QUERY, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE) ) {
            ps.setString( 1, login );
            ps.setString( 2, password );
            try ( ResultSet rs = ps.executeQuery() ) {
                if ( rs.next() ) {
                    int nbConnections = rs.getInt("connections") +1;
                    rs.updateInt("connections", nbConnections);
                    rs.updateRow();
                    user = new User();
                    user.setLogin( rs.getString( "login" ) );
                    user.setPassword( rs.getString( "password" ) );
                    user.setNbConnections( nbConnections );

                }
            }
        }
        return user;
    }
}
