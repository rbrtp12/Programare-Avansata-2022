package DAO;

import Util.Constants;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


@Log
public class DbInsert {

    public static void insertContinent(String name) {
        log.entering("DbInsert", "insertContinent");
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(Constants.DBURL, Constants.USERNAME, Constants.PASSWORD);
            String insertStatement = "INSERT INTO CONTINENTS(id, name) VALUES (SQ_CONTINENTS.nextval, (?))";
            log.info("insertContinentsStatement -> " + insertStatement);
            PreparedStatement statement = connection.prepareStatement(insertStatement);
            statement.setString(1, name);
            statement.executeUpdate();
            connection.close();
        } catch (Exception e) {
            log.severe("Failed with exception: " + e);
        }
    }

    public static void insertCountryFromCSV(String csvPath) {
        log.entering("DbInsert", "insertContinent");
        Connection connection = null;
        BufferedReader reader = null;
        try {
            connection = DriverManager.getConnection(Constants.DBURL, Constants.USERNAME, Constants.PASSWORD);
            reader = new BufferedReader(new FileReader(csvPath));
            List<String> lines = new ArrayList<>();
            String[] columns = null;
            String line = null;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            for (int i = 1; i < lines.size(); i++) {
                columns = lines.get(i).trim().split(",");
                System.out.println(columns[0]);
                String insertStatement = "INSERT INTO COUNTRIES(id, name, code, continent_id) VALUES (SQ_COUNTRIES.nextval, (?), (?), (?))";
                PreparedStatement statement = connection.prepareStatement(insertStatement);
                statement.setString(1, columns[0]);
                statement.setString(2, columns[4]);
                if (columns[5].equals("Europe")) {
                    statement.setInt(3, 1);
                } else if (columns[5].equals("Africa")) {
                    statement.setInt(3, 2);
                } else if (columns[5].equals("South America")) {
                    statement.setInt(3, 3);
                } else if (columns[5].equals("North America")) {
                    statement.setInt(3, 4);
                } else if (columns[5].equals("Asia")) {
                    statement.setInt(3, 5);
                } else if (columns[5].equals("Antarctica")) {
                    statement.setInt(3, 6);
                } else if (columns[5].equals("Australia")) {
                    statement.setInt(3, 7);
                }
                statement.executeUpdate();

            }
            log.info("Insert completed");

        } catch (Exception e) {
            log.severe("Failed with exception: " + e);
        }
    }

    public static void insertCapitalFromCSV(String csvPath) throws FileNotFoundException {
        log.entering("DbInsert", "insertCapitalFromCSV");
        Connection connection = null;
        BufferedReader reader = null;
        try {
            connection = DriverManager.getConnection(Constants.DBURL, Constants.USERNAME, Constants.PASSWORD);
            reader = new BufferedReader(new FileReader(csvPath));
            List<String> lines = new ArrayList<>();
            String[] columns = null;
            String line = null;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            for (int i = 1; i < lines.size(); i++) {
                columns = lines.get(i).trim().split(",");
                String insertStatement = "INSERT INTO CAPITALS(id, name, latitude, longitude, country) VALUES (SQ_CAPITALS.nextval, (?), (?), (?), (SELECT ID FROM Countries where countries.name = (?)))";
                PreparedStatement statement = connection.prepareStatement(insertStatement);
                statement.setString(1, columns[1]);
                statement.setFloat(2, Float.parseFloat(columns[2]));
                statement.setFloat(3, Float.parseFloat(columns[3]));
                statement.setString(4, columns[0]);

                statement.executeUpdate();

            }
            log.info("Insert completed");

        } catch (Exception e) {
            log.severe("Failed with exception: " + e);
        }
    }
}
