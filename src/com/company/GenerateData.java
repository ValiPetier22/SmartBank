package com.company;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GenerateData {
    public static void generateUsersInFile(String fileName) {
        List<User> users = new ArrayList<>();

        User user1 = new User(1, "Vali", "Vali", "vali@gmail.com");
        User user2 = new User(2, "Catalin", "Catalin", "catalin@gmail.com");

        ContBancarExtins c1 = new ContBancarExtins(1, 1000, 0.05);
        c1.adauga(1000);

        ContBancar c2 = new ContBancarExtins(2, 2000, 0);
        c2.adauga(200);

        ContBancar c3 = new ContBancarExtins(3, 4000, 1);
        c2.adauga(100);

        user1.addCont(c1);
        user1.addCont(c3);

        user2.addCont(c2);

        users.add(user1);
        users.add(user2);

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

    public static ContBancar getDummyCont(){
        Random random = new Random();
        return new ContBancarExtins(Math.abs(random.nextInt() % 1000), 100 * Math.abs(random.nextInt() % 1000), (Math.abs(random.nextInt() % 1000)) / 1000f);
    }

    public static User getDummyUser(){
        String[] fnames = {"Ionut", "Gabi", "Andrei"};
        String[] lnames = {"Ionut", "Gabi", "Andrei"};
        String[] emails = {"Ionut@gmail.com", "Gabi@gmail.com", "Andrei@gmail.com"};

        Random random = new Random();

        User user = new User(Math.abs(random.nextInt() % 1000), fnames[Math.abs(random.nextInt()%3)], lnames[Math.abs(random.nextInt()%3)], emails[Math.abs(random.nextInt()%3)]);

        int nrConturi = random.nextInt() % 4 + 1;
        for(int i=0;i<nrConturi;i++){
            user.addCont(getDummyCont());
        }

        return user;
    }

}
