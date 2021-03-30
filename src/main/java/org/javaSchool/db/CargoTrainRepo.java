package org.javaSchool.db;

import org.javaSchool.DBDemo;
import org.javaSchool.model.trainIndustry.CargoTrain;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class CargoTrainRepo {

    public void update(int id, Map<String, Object> parameters) {
        Map<String, Object> map = new HashMap<>();
        map.put("load_weight", 200);
        StringBuilder query = new StringBuilder("UPDATE `transport_system`.`cargo_train` SET ");

        for (Map.Entry<String, Object> entry : map.entrySet()) {
            query.append(entry.getKey() + "=" + entry.getValue() + ", ");
        }
        query.delete(query.length() - 2, query.length());

        query.append("WHERE id=" + id);

        DBDemo db = new DBDemo();


        try (Connection con = db.getConnection()) {
            PreparedStatement statement = con.prepareStatement(query.toString());
            int count = statement.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }


    }

    public void insert(CargoTrain cargoTrain) {
        DBDemo db = new DBDemo();
        ResultSet results = null;
        try (Connection con = db.getConnection();) {
            StringBuilder query = new StringBuilder("INSERT INTO `transport_system`.`cargo_train` SET plate_number=?, load_capacity = ?, load_weight=?, engine_type=?");
            PreparedStatement preparedStatement = con.prepareStatement(query.toString());
            preparedStatement.setString(1, cargoTrain.getPlateNumber());
            preparedStatement.setInt(2, cargoTrain.getLoadCapacity());
            preparedStatement.setInt(3, cargoTrain.getLoadCapacity());
            preparedStatement.setString(4, cargoTrain.getEngineType().toString());
            int count = preparedStatement.executeUpdate();
            System.out.println();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
}
