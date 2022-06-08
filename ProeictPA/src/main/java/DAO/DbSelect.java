package DAO;

import Commands.Executer;
import Utils.Constants;
import lombok.extern.java.Log;
import net.dv8tion.jda.api.entities.User;

import java.sql.*;

@Log
public class DbSelect {
    public static int getZodiacIndex(User user){
        String username = user.getName();
        Connection connection = null;
        ResultSet rs = null;
        String zodiacIndex = null;
        int check = 0;
        try {
            connection = DriverManager.getConnection(Constants.DBURL, Constants.USERNAME, Constants.PASSWORD);
            String selectStatement = "Select zodiacId zodiacId from schemadinberceni.members where name = (?)";
            log.info("selectZodiacIndexStatement -> " + selectStatement);
            PreparedStatement statement = connection.prepareStatement(selectStatement);
            statement.setString(1, username);
            statement.execute();
            rs = statement.getResultSet();

            if(rs != null){
                while (rs.next())
                     zodiacIndex = rs.getString("zodiacId");
                if(zodiacIndex == null)
                    check = -1;
                else
                check = Integer.parseInt(zodiacIndex);
            }

            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



        return check;
    }
}
