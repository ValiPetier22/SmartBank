package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BankManagerFileImpl implements BankManager {

    private String fileName;

    public BankManagerFileImpl(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<User> getUsers() {
        List<User> users = null;
        try {
            FileInputStream fileIn = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            users = (List<User>) in.readObject();
            in.close();
            fileIn.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        if (users == null) {
            users = new ArrayList<>();
        }

        return users;
    }

    @Override
    public void updateUsers(List<User> users) {
        try {
            FileOutputStream fileOut = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(users);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in " + fileName);
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
}
