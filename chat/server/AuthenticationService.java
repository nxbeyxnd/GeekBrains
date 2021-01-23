package server;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AuthenticationService {

    public void changeNickname(String nick, String oldName) {
        try {
            Connection connection = ConnectionService.connect();
            PreparedStatement statement = connection.prepareStatement("UPDATE Account SET name = ? WHERE name = ?");

            statement.setString(1, nick);
            statement.setString(2, oldName);

            statement.executeUpdate();
            statement.close();
            connection.close();

        } catch (Exception e){
            throw new RuntimeException("SWW", e);
        }
    }

    public String findNicknameByLoginAndPassword(String login, String password) {
        try {
            Connection connection = ConnectionService.connect();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Account WHERE email = ? AND password = ?");

            statement.setString(1, login);
            statement.setString(2, password);

            ResultSet rs = statement.executeQuery();
            if (rs.next()){
                new User(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("password"));
                return rs.getString("name");

            }

            statement.close();
            connection.close();
            return null;

        } catch (Exception e){
            throw new RuntimeException("SWW", e);
        }
    }


}
