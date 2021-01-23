package server;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionService {

    private ConnectionService(){

    }

    public static Connection connect(){
        try {
//            return DriverManager.getConnection("jdbc:mysql://localhost:8080/test", "nxbe", "root");
            return DriverManager.getConnection("jdbc:mysql://192.168.64.2/chatAccount", "nxbe", "root");
        } catch (SQLException e) {
            throw new RuntimeException("SWW", e);
        }
    }

    public static void close(Connection connection){
        try{
            connection.close();
        }catch (SQLException th){
            th.printStackTrace();
        }
    }
}
