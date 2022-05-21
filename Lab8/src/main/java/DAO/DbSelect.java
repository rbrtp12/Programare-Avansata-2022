package DAO;

import Util.Constants;
import Util.Utils;
import Views.CapitalsView;
import lombok.extern.java.Log;

import java.sql.*;

@Log
public class DbSelect {

    public static void findContinentById(int id){
        log.entering("DbSelect", "findContinentById");
        Connection connection = null;
        ResultSet rs = null;
        try{
            connection = DriverManager.getConnection(Constants.DBURL, Constants.USERNAME, Constants.PASSWORD);
            String selectStatement = "SELECT * FROM CONTINENTS c where c.id = (?)";
            log.info("selectContinentsStatement -> " + selectStatement);
            PreparedStatement statement = connection.prepareStatement(selectStatement);
            statement.setInt(1, id);
            rs = statement.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount();

            while (rs.next()) {

                for (int i = 1; i <= columnsNumber; i++) {
                    System.out.print(rsmd.getColumnName(i) + "     ");
                }
                System.out.println("\n" + "----------------------");
                for (int i = 1; i <= columnsNumber; i++) {
                    String columnValue = rs.getString(i);
                    System.out.print(columnValue + "     ");
                }
                System.out.println("\n");
            }


        }
        catch (Exception e){
            log.severe("Failed with exception: " + e);
        }
    }

    public static void findCountryById(int id){
        log.entering("DbSelect", "findCountryById");
        Connection connection = null;
        ResultSet rs = null;
        try{
            connection = DriverManager.getConnection(Constants.DBURL, Constants.USERNAME, Constants.PASSWORD);
            String selectStatement = "SELECT * FROM COUNTRIES c where c.id = (?)";
            log.info("selectCountryStatement -> " + selectStatement);
            PreparedStatement statement = connection.prepareStatement(selectStatement);
            statement.setInt(1, id);
            rs = statement.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount();

            while (rs.next()) {

                for (int i = 1; i <= columnsNumber; i++) {
                    System.out.print(rsmd.getColumnName(i) + "     ");
                }
                System.out.println("\n" + "----------------------");
                for (int i = 1; i <= columnsNumber; i++) {
                    String columnValue = rs.getString(i);
                    System.out.print(columnValue + "     ");
                }
                System.out.println("\n");
            }


        }
        catch (Exception e){
            log.severe("Failed with exception: " + e);
        }
    }

    public static void findCapitalById(CapitalsView capital, int id){
        log.entering("DbSelect", "findCapitalById");
        Connection connection = null;
        ResultSet rs = null;
        try{
            connection = DriverManager.getConnection(Constants.DBURL, Constants.USERNAME, Constants.PASSWORD);
            String selectStatement = "SELECT * FROM CAPITALS c where c.id = (?)";
            log.info("selectCountryStatement -> " + selectStatement);
            PreparedStatement statement = connection.prepareStatement(selectStatement);
            statement.setInt(1, id);
            rs = statement.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            while (rs.next()) {
                capital.setId(rs.getInt(1));
                capital.setName(rs.getString(2));
                capital.setLatitude(rs.getFloat(3));
                capital.setLongitude(rs.getFloat(4));
                capital.setCountry(rs.getInt(5));
                System.out.println(capital.toString());
            }


        }
        catch (Exception e){
            log.severe("Failed with exception: " + e);
        }
    }

    public static void capitalsDistance(CapitalsView capital1, CapitalsView capital2){
        double theta = capital1.getLongitude() - capital1.getLongitude();
        double dist = Math.sin(Utils.deg2rad(capital1.getLatitude()) * Math.sin(Utils.deg2rad(capital2.getLatitude())) + Math.cos(Utils.deg2rad(capital1.getLatitude())) * Math.cos(Utils.deg2rad(capital2.getLatitude())) * Math.cos(Utils.deg2rad(theta)));
        dist = Math.acos(dist);
        dist = Utils.rad2deg(dist);
        dist = dist * 60 * 1.1515 * 1.609344;

        System.out.println("Distance between " + capital1.getName() + " and " + capital2.getName() + " is: " + dist);
    }
}
