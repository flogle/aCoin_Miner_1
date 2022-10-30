package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import data.ACoinData;
import data.ACoinUserData;
import data.User;

public class SQL {

    private Connection conn;
    

    public SQL() {
        
        this.getConnection();

    }

    public Connection getConnection() {

        try {

            String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/flogle";
            String username = SQLUser.username;
            String password = SQLUser.password;

            Class.forName(driver);

            this.conn = DriverManager.getConnection(url, username, password);

            System.out.println("Connected to db");

            return this.conn;

        } catch (Exception ex) {

            ex.printStackTrace();
            return null;

        }

    }

    public User getUserByID(long userid) {

        try {


            PreparedStatement query = this.conn.prepareStatement("SELECT * FROM users WHERE id = ? LIMIT 1");

            query.setLong(1, userid);

            ResultSet result = query.executeQuery();

            User user = null;

            while (result.next()) {

                user = new User(result.getLong("id"), result.getString("username"), result.getString("password_hash"));

            }

            return user;



        } catch (Exception e) {

            e.printStackTrace();

            
        }
        
        return null;

    }

    
    public ACoinData getACoinData() {

        try {


            PreparedStatement query = this.conn.prepareStatement("SELECT * FROM acoin_globals WHERE id = ? LIMIT 1");

            query.setLong(1, 1L);

            ResultSet result = query.executeQuery();

            ACoinData aCoinData = null;

            while (result.next()) {

            	aCoinData = new ACoinData(result.getLong("id"), result.getBoolean("canMine"), result.getString("current_app_version"));

            }

            return aCoinData;



        } catch (Exception e) {

            e.printStackTrace();

            
        }
        
        return null;

    }
    
    public boolean addAcoins(long user_id, double acoins) {

        try {


            PreparedStatement query = this.conn.prepareStatement("CALL addAcoin(?, ?)");

            query.setLong(1, user_id);
            query.setDouble(2, acoins);
            
            query.executeQuery();
            
            return true;


        } catch (Exception e) {

            e.printStackTrace();

            
        }
        
        return false;

    }
    
    public ACoinUserData getAcoinUserDataByID(long acoinID) {

        try {

            PreparedStatement query = this.conn.prepareStatement("SELECT * FROM acoin_data WHERE id = ? LIMIT 1");

            query.setLong(1, acoinID);

            ResultSet result = query.executeQuery();

            ACoinUserData user = null;

            while (result.next()) {

                user = new ACoinUserData(result.getLong("id"), result.getLong("user_id"), result.getDouble("acoins"), result.getBoolean("locked"), result.getBoolean("admin"));

            }

            return user;

        } catch (Exception e) {

            e.printStackTrace();

        }

        return null;

    }

}
