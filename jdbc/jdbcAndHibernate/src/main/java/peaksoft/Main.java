package peaksoft;

import peaksoft.model.User;
import peaksoft.service.UserService;
import peaksoft.service.UserServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
//      TODO create table
        UserService userService = new UserServiceImpl();
//       userService.createUsersTable();


//      TODO getAll method
//     System.out.println(userService.getAllUsers());

//      TODO removeUserById method
//      userService.removeUserById(1);

//      TODO cleanUsersTable
//      userService.cleanUsersTable();

//      TODO drop table
      userService.dropUsersTable();

//                      TODO HIBERNATE
//        userService.saveUser("Jandar", "Usenov", (byte) 32);
//      TODO Save method
//      userService.saveUser("Jandar", "Usenov", (byte) 31);
//      userService.saveUser("Ali", "Bekov", (byte) 26);
//      userService.saveUser("Nur", "Talipov", (byte) 36);
//      userService.saveUser("Kai", "Sanjarov", (byte) 22);
//      userService.saveUser("Bek", "Borbiev", (byte) 33);
//      userService.saveUser("Guli", "Jamalova", (byte) 20);
//
//        TODO removeUserById method
//        userService.removeUserById(6L);

//          TODO getAll
//        System.out.println(userService.getAllUsers());

//        TODO cleanUsersTable method
//        userService.cleanUsersTable();
    }
}