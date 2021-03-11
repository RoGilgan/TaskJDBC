package jm.task.core.jdbc.util;


import jm.task.core.jdbc.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import org.hibernate.service.ServiceRegistry;
import java.sql.SQLException;
import java.util.Properties;

public class Util {

//    private final static String HOST = "jdbc:mysql://localhost:3306/jmdb?useUnicode=true&useSSL=true&" +
//            "useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
//    private final static String USERNAME = "root";
//    private final static String PASSWORD = "Roman190190Roman";

    private Util() {

    }

    public static SessionFactory getSessionFactory() {

            Configuration configuration = new Configuration();

            Properties properties = new Properties();
            properties.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
            properties.setProperty("hibernate.connection.url",
                    "jdbc:mysql://localhost:3306/jmdb?useUnicode=true&useSSL=true&useJDBCCompliantTimezoneShift=true&" +
                            "useLegacyDatetimeCode=false&serverTimezone=UTC");
            properties.setProperty("hibernate.connection.username", "root");
            properties.setProperty("hibernate.connection.password", "Roman190190Roman");
            properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");

            configuration.setProperties(properties);
            configuration.addAnnotatedClass(User.class);

            return configuration.buildSessionFactory();
    }

}
