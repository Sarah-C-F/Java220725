package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectUtil {


    public static Connection getConnection() {

        try {

            Connection conn = DriverManager.getConnection(System.getenv("AZURE_SQL_JDBC"));
            System.out.println(conn);
//            Statement statement= conn.createStatement();
//            statement.execute("insert into employees values (168, 'Billy', 'bones')");

            return conn;

        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;

    }


}
