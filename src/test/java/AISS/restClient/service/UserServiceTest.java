package AISS.restClient.service;

import AISS.restClient.model.users.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {
    @Autowired
    UserService service;

    @Test
    @DisplayName("Get all users")
    void findAllUsers() {
        List<User> users = service.findAllUsers();
        assertTrue(!users.isEmpty());
        System.out.println(users);
    }

    @Test
    @DisplayName("Get user by his id")
    void findUser() {
        User user = service.findUser(2);
        System.out.println(user);
    }

    @Test
    @DisplayName("Create a new user")
    void postUser(){
        User user = service.postUser("Miguel","Galan");
        System.out.println(user);
    }

    @Test
    @DisplayName("Update a user ")
    void putUser(){
        service.putUser(2,"Miguel","Galan");
    }

    @Test
    @DisplayName("Delete user")
    void deleteUser(){
        service.deleteUser(2);
    }




}