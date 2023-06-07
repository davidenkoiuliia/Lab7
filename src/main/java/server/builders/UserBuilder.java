package server.builders;


import java.util.Scanner;


public class UserBuilder {
    public static String getUserName(Scanner reader) {
        String login;
        System.out.println("Введите логин: ");
        login = reader.nextLine();
        return login;
    }

    public static String getPasswordLogin(Scanner reader) {
        String login;
        System.out.println("Введите пароль:");
        login = reader.nextLine();
        return login;
    }
}