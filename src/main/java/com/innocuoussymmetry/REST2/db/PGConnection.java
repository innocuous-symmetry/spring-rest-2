package com.innocuoussymmetry.REST2.db;

import java.sql.*;

public class PGConnection {
    private String url;
    public PGConnection() {
        try {
            url = "postgresql://localhost:5432/rest2db?user=postgres&password=postgres&ssl=true";
            Connection conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e);
        }

    }
}
