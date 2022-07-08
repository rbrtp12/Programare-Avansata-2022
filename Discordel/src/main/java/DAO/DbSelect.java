package DAO;

import Commands.Executer;
import Utils.Constants;
import lombok.extern.java.Log;
import net.dv8tion.jda.api.entities.User;

import java.sql.*;

@Log
public class DbSelect {
    public static int getZodiacIndex(User user) {
        String username = user.getName();
        Connection connection = null;
        ResultSet rs = null;
        String zodiacIndex = null;
        int check = 0;
        try {
            connection = DriverManager.getConnection(Constants.DBURL, Constants.USERNAME, Constants.PASSWORD);
            String selectStatement = "Select zodiacId zodiacId from members where name = (?)";
            log.info("selectZodiacIndexStatement -> " + selectStatement);
            PreparedStatement statement = connection.prepareStatement(selectStatement);
            statement.setString(1, username);
            statement.execute();
            rs = statement.getResultSet();

            if (rs != null) {
                while (rs.next())
                    zodiacIndex = rs.getString("zodiacId");
                if (zodiacIndex == null)
                    check = -1;
                else check = Integer.parseInt(zodiacIndex);
            }

            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return check;
    }

    public static int getZodiacIndexForOther(String sign) {

        Connection connection = null;
        ResultSet rs = null;
        String zodiacIndex = null;
        int check = 0;
        try {
            connection = DriverManager.getConnection(Constants.DBURL, Constants.USERNAME, Constants.PASSWORD);
            String selectStatement = "Select id zodiacId from zodiac where name = (?)";
            log.info("selectZodiacIndexStatement -> " + selectStatement);
            PreparedStatement statement = connection.prepareStatement(selectStatement);
            statement.setString(1, sign);
            statement.execute();
            rs = statement.getResultSet();

            if (rs != null) {
                while (rs.next()) zodiacIndex = rs.getString("zodiacId");
                if (zodiacIndex == null)
                    check = -1;
                else check = Integer.parseInt(zodiacIndex);
            }

            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return check;
    }

    public static String getZodiacSignFromIndex(int index) {
        Connection connection = null;
        ResultSet rs = null;
        String zodiacSign = null;
        try {
            connection = DriverManager.getConnection(Constants.DBURL, Constants.USERNAME, Constants.PASSWORD);
            String selectStatement = "Select name zodiacSign from zodiac where id = (?)";
            log.info("selectZodiacIndexStatement -> " + selectStatement);
            PreparedStatement statement = connection.prepareStatement(selectStatement);
            statement.setInt(1, index);
            statement.execute();
            rs = statement.getResultSet();

            if (rs != null) {
                while (rs.next())
                    zodiacSign = rs.getString("zodiacSign");
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return zodiacSign;
    }

    public static int checkSubscription(User user){
        String username = user.getName();
        Connection connection = null;
        ResultSet rs = null;
        String subscription = null;
        int check = 0;
        try {
            connection = DriverManager.getConnection(Constants.DBURL, Constants.USERNAME, Constants.PASSWORD);
            String selectStatement = "Select subscription subscription from members where name = (?)";
            log.info("selectSubscriptionStatement -> " + selectStatement);
            PreparedStatement statement = connection.prepareStatement(selectStatement);
            statement.setString(1, username);
            statement.execute();
            rs = statement.getResultSet();

            if (rs != null) {
                while (rs.next())
                    subscription = rs.getString("subscription");
                if(Integer.parseInt(subscription) == 1){
                    check = 1;
                }

            }

            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return check;
    }
}
