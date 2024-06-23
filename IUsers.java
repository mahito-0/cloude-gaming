package Classes;

import java.lang.*;

public interface IUsers {
    void addUser(user u);

    user getUser(int index, String pass);

    void deleteUser(user u);

    void updateUser(user u);
}