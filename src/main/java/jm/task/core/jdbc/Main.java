package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        UserService userService = new UserServiceImpl();

        userService.createUsersTable();

        userService.saveUser("Roman", "Volchek", (byte)24);
        System.out.println("User с именем Роман добавлен");

        userService.saveUser("Roman", "Volchek", (byte)24);
        System.out.println("User с именем Роман добавлен");

        userService.saveUser("Roman", "Volchek", (byte)24);
        System.out.println("User с именем Роман добавлен");

        userService.saveUser("Roman", "Volchek", (byte)24);
        System.out.println("User с именем Роман добавлен");

        List<User> userList = userService.getAllUsers();
        userList.forEach(System.out::println);

        userService.cleanUsersTable();

        userService.dropUsersTable();
    }
}
