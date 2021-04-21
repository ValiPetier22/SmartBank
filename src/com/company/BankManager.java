package com.company;
import java.util.List;

public interface BankManager {
    List<User> getUsers();
    void updateUsers(List<User> users);
}
