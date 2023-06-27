import java.util.Scanner;

public interface UserOperation
{
    void addNewUser(DataBase dataBase, Scanner scanner, Address address, PhoneNumber phoneNumber);
    void deleteUser(String id, DataBase dataBase);
    void editUser(String id, DataBase dataBase, Scanner scanner);
    void searchUser(String id, DataBase dataBase);
    void listUsers(DataBase dataBase);
}
