package DAO;

import Utils.Constants;
import lombok.extern.java.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@Log
public class DbInsert {
    public static void insertMembers(String name, int zodiacId){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(Constants.DBURL, Constants.USERNAME, Constants.PASSWORD);
            String insertStatement = "INSERT INTO STUDENT.Members VALUES (null, (?), (?))";
            log.info("insertMembersStatement -> " + insertStatement);
            PreparedStatement statement = connection.prepareStatement(insertStatement);
            statement.setString(1, name);
            statement.setInt(2, zodiacId);
            statement.executeUpdate();
            connection.close();
        } catch (Exception e) {
            log.severe("Failed with exception: " + e);
        }
    }

}
