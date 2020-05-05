package ru.nik66.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Test {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false";
        String name = "hbstudent";
        String pass = "hbstudent";

        System.out.println("Start connection:");
        try {
            Connection connection = DriverManager.getConnection(url, name, pass);
            System.out.println("Connection success!");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

}
