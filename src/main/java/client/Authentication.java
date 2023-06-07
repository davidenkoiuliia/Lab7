package client;





import server.controller.VehicleController;
import server.services.CurrentUserManager;

import java.util.NoSuchElementException;
import java.util.Scanner;

import static server.builders.UserBuilder.getPasswordLogin;
import static server.builders.UserBuilder.getUserName;


public class Authentication {
    private final CurrentUserManager userManager;
    private final VehicleController controller;
    private final Scanner reader = new Scanner(System.in);

    public Authentication(VehicleController controller, CurrentUserManager userManager) {
        this.controller = controller;
        this.userManager = userManager;
    }

    private void configUserManager(String username) {
        userManager.setUserName(username);
    }

    public CurrentUserManager start() {
        try {
            System.out.println("Добро пожаловать! Выберите что сделать: 1 - войти в аккаунт, 2 - зарегистрироваться.");
            switch (reader.nextLine()) {
                case "1" -> {
                    return login();
                }
                case "2" -> {
                    return registerUser();
                }
                case "exit" -> {
                    System.exit(0);
                    return null;
                }
                default -> {
                    return start();
                }
            }
        } catch (NoSuchElementException e){
            System.out.println("Завершение программы.");
            System.exit(1);
            return new CurrentUserManager();
        }
    }

    public CurrentUserManager registerUser() {
        String username = getUserName(reader);
        String password = getPasswordLogin(reader);
        if (controller.getUserNameList().contains(username)) {
            System.out.println("Пользователь с данным никнеймом существует. Попробуйте еще раз.");
            registerUser();
        } else {
            controller.userRegister(username, password);
            System.out.println("Пользователь успешно зарегестрирован.");
            configUserManager(username);
        }
        return userManager;
    }

    public CurrentUserManager login() {
        String username = getUserName(reader);
        String password = getPasswordLogin(reader);
        if (controller.checkUserPassword(username, password)) {
            System.out.println("Успешный вход!");
            configUserManager(username);
        } else {
            System.out.println("Неверный логин или пароль.");
            login();
        }
        return userManager;
    }


    public CurrentUserManager getUserManager() {
        return userManager;
    }
}
