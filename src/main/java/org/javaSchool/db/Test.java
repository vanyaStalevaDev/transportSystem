package org.javaSchool.db;

import java.sql.*;

public class Test {

    public void readDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String query = "SELECT * FROM transport_system.cargo_aircraft";

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/transport_system", "test", "test123@")) {
            try (Statement statement = con.createStatement()) {
                try (ResultSet rs = statement.executeQuery(query);){
                    while (rs.next()) {
                        System.out.printf("Id:%d, plateNum :%s, engineType %s, loadWeight: %d, loadCapacity: %d", rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5));
                    }
                } catch (Exception ee) {
                    ee.printStackTrace();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public void writeDB(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String query = "INSERT INTO `transport_system`.`cargo_train` (`plate_number`, `engine_type`) VALUES ('1012AA', 'DIESEL')";

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/transport_system", "test", "test")) {
            try (Statement statement = con.createStatement()) {
                int rows = statement.executeUpdate(query);
                System.out.println();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
