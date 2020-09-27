package com.lobanova.electroniclibrary.services;

import com.lobanova.electroniclibrary.DataBase;
import com.lobanova.electroniclibrary.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final CommentService commentService;
    private final AddressService addressService;

    @Autowired
    public UserService(CommentService commentService, AddressService addressService) {
        this.commentService = commentService;
        this.addressService = addressService;
    }

    public List<User> getAllUsers() {
        return DataBase.users;
    }

    public User getUserById(Integer id) {
        Optional<User> oldUser =  getAllUsers().stream().filter(user -> user.getId().equals(id)).findFirst();
        return oldUser.orElse(null);
    }

    public boolean addUser(User user) {
        return getAllUsers().add(user);
    }

    public boolean updateUser (User user) {
        boolean isUpdated = false;
        User oldUser = getUserById(user.getId());
        List<User> users = getAllUsers();
        if (oldUser == null) {
            users.add(user);
            isUpdated = true;
        } else if (!oldUser.equals(user)) {
            users.remove(users.indexOf(oldUser));
            users.add(user);
            isUpdated = true;
        }
        return isUpdated;
    }

    public void deleteUser(Integer id) {
        User userForDelete = getUserById(id);
        List<User> users = getAllUsers();
        if (userForDelete != null) {
            users.remove(users.indexOf(userForDelete));
        }
    }
}
