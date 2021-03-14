package jm.task.core.jdbc.util;


import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Properties;

public class Util {

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
