package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SQL {

    private Connection conn;
    

    public SQL() {
        
        try {

            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/flogle";
            String username = SQLUser.username;
            String password = SQLUser.password;
            
            Class.forName(driver);

            this.conn = DriverManager.getConnection(url, username, password);

            System.out.println("Connected to db");

        } catch (Exception ex) {

            ex.printStackTrace();

        }

    }

}
