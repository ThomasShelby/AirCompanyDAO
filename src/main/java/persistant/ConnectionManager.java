package persistant;

/**
 * Created by Mykola- on 21.12.2015.
 */
import java.sql.Connection;
import java.sql.DriverManager;

public final class ConnectionManager {

    private static Connection conn = null;

    public static Connection getConnection() {
        if(conn == null)
            initConnect();

        return conn;
    }

    private static void initConnect(){
        try {
            String userName = "root";
            String password = "root";
            String url = "jdbc:mysql://127.0.0.1:3306/task?characterEncoding=UTF-8";
            Class.forName ("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(url, userName, password);
        }
        catch (Exception e) {
            System.err.println (e.getMessage());
        }
    }
}