package loginObjectOriented;

import java.sql.*;

public class DatabaseManager {
    private  String url ="jdbc:mysql://localhost:3306/javadatabase";
    private String dbUser = "root";
    private String dbPassword = "";

    public boolean authenticatUser(String username, String password){
        String query = "SELECT *FROM credential WHERE username = ? AND password = ?";
        
        try(Connection conn = DriverManager.getConnection(url,dbUser,dbPassword);
        PreparedStatement pst = conn.prepareStatement(query)){
            pst.setString(1,username);
            pst.setString(2,password);
            try(ResultSet rs = pst.executeQuery()){
                return rs.next();
            }
        }catch(SQLException e ){
            e.printStackTrace();
            return false;
        }
    }
    public boolean addUser(String username,String password){
        String insertQuery = "INSERT INTO credential(username,password)VALUES(?,?)";
       
        try(Connection conn =DriverManager.getConnection(url,dbUser, dbPassword);
            PreparedStatement pst =conn.prepareStatement(insertQuery)){
                pst.setString(1, username);
                pst.setString(2, password);

                int rowsAffected = pst.executeUpdate();
                return rowsAffected > 0;
        }catch(SQLException e){
            if (e.getErrorCode() == 1062) {
                System.out.println("Username already exists.");
            }else{
                e.printStackTrace();
            }
            return false;
        }
    }
    public boolean deleteUser(String username){
        String insertQuery = "DELETE FROM credential WHERE username = ?";
       
        try(Connection conn =DriverManager.getConnection(url,dbUser, dbPassword);
            PreparedStatement pst =conn.prepareStatement(insertQuery)){
                pst.setString(1, username);
               

                int rowsAffected = pst.executeUpdate();
                return rowsAffected > 0;
        }catch(SQLException e){
            if (e.getErrorCode() == 1062) {
                System.out.println("Username already exists.");
            }else{
                e.printStackTrace();
            }
            return false;
        }
    }
    public boolean searchUser(String username){
        String insertQuery = "SELECT * FROM credential WHERE  username = ?";
       
        try(Connection conn =DriverManager.getConnection(url,dbUser, dbPassword);
            PreparedStatement pst =conn.prepareStatement(insertQuery)){
                pst.setString(1, username);
               
                try(ResultSet rs = pst.executeQuery()){
                    return rs.next();
                }
            }catch(SQLException e ){
                e.printStackTrace();
                return false;
            }
        }
        public boolean updateUser(String username,String password){
            String insertQuery = "UPDATE credential SET password=? WHERE username = ?";
           
            try(Connection conn =DriverManager.getConnection(url,dbUser, dbPassword);
                PreparedStatement pst =conn.prepareStatement(insertQuery)){
                    pst.setString(1, password);
                    pst.setString(2, username);
                   
    
                    int rowsAffected = pst.executeUpdate();
                    return rowsAffected > 0;
            }catch(SQLException e){
                if (e.getErrorCode() == 1062) {
                    System.out.println("Username already exists.");
                }else{
                    e.printStackTrace();
                }
                return false;
            }
        }
    }

