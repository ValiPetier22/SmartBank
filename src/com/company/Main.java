package com.company;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        BankManager manager = new BankManagerFileImpl("users.ser");
        List<User> users = manager.getUsers();

        Scanner in = new Scanner(System.in);

        while (true) {
            String input = in.nextLine().strip().replace("\n","");

            if (input.equals("add")) {
                User dummyUser = GenerateData.getDummyUser();
                users.add(dummyUser);
                manager.updateUsers(users);
            } else if (input.equals("remove")) {
                users.remove(0);
                manager.updateUsers(users);
            } else if (input.equals("print")) {
                for (User user : users) {
                    System.out.println(user.getId() + " " + user.getFirstName());
                    List<ContBancar> conturi = user.getConturi();
                    for (ContBancar cont : conturi) {
                        System.out.println("    " + cont.getId() + " " + cont.suma);
                    }
                }
            } else {
                System.out.println("Comanda invalida");
            }
        }
    }
}