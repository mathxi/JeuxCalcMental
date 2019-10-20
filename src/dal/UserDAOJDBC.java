package dal;

import bo.User;

import java.sql.*;
import java.util.List;

public class UserDAOJDBC extends DataAccessObjectJDBC<User> {

    private static final String AUTHENT_QUERY = "SELECT * FROM user WHERE login = ? AND password = ?";
    private static final String GET_USER_QUERY = "SELECT * FROM user WHERE id_user = ? ";
    private static final String UPDATE_USER_TOPSCORE = "UPDATE result SET top_result = ? WHERE id_user = ?";

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
                    user = new User();
                    user.setId_user( rs.getInt( "id_user" ) );
                    user.setLogin( rs.getString( "login" ) );
                    user.setPassword( rs.getString( "password" ) );
                    user.setTopResult( rs.getInt("top_result") );

                }
            }
        }
        return user;
    }
    public User getUser( Integer id) throws SQLException {

        User user = null;
        try ( Connection connection = DriverManager.getConnection( dbUrl, dbLogin, dbPwd );
              PreparedStatement ps = connection.prepareStatement(GET_USER_QUERY, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE) ) {
            ps.setInt( 1, id );
            try ( ResultSet rs = ps.executeQuery() ) {
                if ( rs.next() ) {
                    user = new User();
                    user.setId_user( rs.getInt( "id_user" ) );
                    user.setLogin( rs.getString( "login" ) );
                    user.setPassword( rs.getString( "password" ) );
                    user.setTopResult( rs.getInt("top_result") );

                }
            }
        }
        return user;
    }

    public void UpdateTopScore( int id, int top_score) throws SQLException {

        try ( Connection connection = DriverManager.getConnection( dbUrl, dbLogin, dbPwd );
              PreparedStatement ps = connection.prepareStatement(UPDATE_USER_TOPSCORE) ) {
            ps.setInt( 1,  top_score );
            ps.setInt( 2, id );
            ps.executeUpdate();
        }
    }
}
