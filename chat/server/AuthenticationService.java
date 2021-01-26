package server;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthenticationService {

    public void changeNickname(String nick, String oldName) throws SQLException {
        Connection connection = ConnectionService.connect();
        PreparedStatement statement = connection.prepareStatement("UPDATE Account SET name = ? WHERE name = ?");

        try {
            connection.setAutoCommit(false);

            statement.setString(1, nick);
            statement.setString(2, oldName);
            statement.executeUpdate();

            connection.commit();
        } catch (Exception e) {
            throw new RuntimeException("SWW", e);
        } finally {
            statement.close();
            ConnectionService.close(connection);
        }
    }

    public String findNicknameByLoginAndPassword(String login, String password) throws SQLException {
        Connection connection = ConnectionService.connect();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM Account WHERE email = ? AND password = ?");
        try {
            statement.setString(1, login);
            statement.setString(2, password);

            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                new User(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("password"));
                return rs.getString("name");
            }
            return null;
        } catch (Exception e) {
            throw new RuntimeException("SWW", e);
        } finally {
            statement.close();
            ConnectionService.close(connection);
        }
    }
}
