package jm.task.core.jdbc.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

    private final static String HOST = "jdbc:mysql://localhost:3306/jmdb?useUnicode=true&useSSL=true&" +
            "useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private final static String USERNAME = "root";
    private final static String PASSWORD = "Roman190190Roman";

    public Util() {

    }

    public static Connection getConnection() throws SQLException {

        return DriverManager.getConnection(HOST, USERNAME, PASSWORD);
    }
}
