package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserDaoHibernateImpl implements UserDao {

    public UserDaoHibernateImpl() {

    }

    @Override
    public void createUsersTable() {
        Session session = Util.getSessionFactory().openSession();
        session.createSQLQuery("CREATE TABLE IF NOT EXISTS user (id BIGINT(19) NOT NULL AUTO_INCREMENT, " +
                    "name VARCHAR(40) NOT NULL, lastName VARCHAR(40) NOT NULL, " +
                    "age TINYINT(3) NOT NULL, PRIMARY KEY (id));");
        session.close();
    }

    @Override
    public void dropUsersTable() {
        Session session = Util.getSessionFactory().openSession();
        session.createSQLQuery("DROP TABLE IF EXISTS user;");
        session.close();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {

        try (Session session = Util.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.persist(new User(name, lastName, age));
            session.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeUserById(long id) {
        Session session = Util.getSessionFactory().openSession();
            session.getTransaction();
            session.delete(String.valueOf(User.class), id);
            session.close();
        }

    @Override
    public List<User> getAllUsers() {

        return  (List<User>) Util.getSessionFactory().openSession().createQuery("From User").list();
    }

    @Override
    public void cleanUsersTable() {
        Session session = Util.getSessionFactory().openSession();
        session.delete("user", User.class);
        session.close();
        }
    }
