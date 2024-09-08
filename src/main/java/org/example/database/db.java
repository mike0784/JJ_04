package org.example.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class db {
    private static final String url = "jdbc:mysql://localhost:3306";
    private static final String user = "root";
    private static final String password = "root";

    public static void con() {
        try (Connection con = DriverManager.getConnection(url, user, password)){
            Statement stment = con.createStatement();
            stment.execute("DROP SCHEMA `test`;");
            stment.execute("CREATE SCHEMA `test`;");
            stment.execute("CREATE TABLE IF NOT EXISTS `test`.`Person` (`id` INT NOT NULL AUTO_INCREMENT, `name` VARCHAR(60) NULL, `age` INT NULL, PRIMARY KEY(`id`));");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
