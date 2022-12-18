package org.example;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Queries {

    public void addUsers(String fullName, String username, String password){
        String QUERY = "INSERT INTO users(fullname, username, password, type)" +
                "VALUES ('"+fullName+"', '"+ username+"', '"+ password+"', 'user');";

        try {
            DBUtils.getConnection().createStatement().execute(QUERY);
            DBUtils.getConnection().close();
        }
        catch (Exception e){
            System.out.println("Method: addUsers, Queries class");
            System.out.println(e.getMessage());
        }
    }

    public String checkUser(String username, String password) throws SQLException {
        String QUERY1 = "Select * From users where username ='"+username+"' and password='"+password+"';";
        ResultSet result = null;
        try {
             result = DBUtils.getConnection().createStatement().executeQuery(QUERY1);
            DBUtils.getConnection().close();
        }
        catch (Exception e){
            System.out.println("Method: checkUser, Queries class");
            System.out.println(e.getMessage());
        }
        if (result.wasNull()){
            return "none";
        }
        Boolean isAdmin = result.getString("type").equals("admin");
        if (isAdmin){
            return "admin";
        }
        if (result.getString("type").equals("user")){
            return "user";
        }
        return "none";
    }

    public Boolean checkDuplicate(String username) throws SQLException {
        String QUERY = "Select * From users where username ='"+username+"';";
        ResultSet result = null;
        try {
            result = DBUtils.getConnection().createStatement().executeQuery(QUERY);
        }
        catch (Exception e){
            System.out.println("Method: checkDuplicate, Queries class");
            System.out.println(e.getMessage());
        }
        if (result.wasNull()){
            return true;
        }
        return false;
    }
}
