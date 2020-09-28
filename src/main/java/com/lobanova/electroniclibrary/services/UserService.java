package com.lobanova.electroniclibrary.services;

import com.lobanova.electroniclibrary.DataBase;
import com.lobanova.electroniclibrary.dtos.UserDto;
import com.lobanova.electroniclibrary.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private UserDto convertUserToUserDto(User user) {
        return UserDto.builder().id(user.getId()).name(user.getName()).surname(user.getSurname()).address(user.getAddress()).comments(user.getComments()).type(user.getType()).build();
    }

    private User convertUserDtoToUser(UserDto user) {
        return User.builder().id(user.getId()).name(user.getName()).surname(user.getSurname()).address(user.getAddress()).comments(user.getComments()).type(user.getType()).build();
    }

    private List<User> getAllUsers() {
        return DataBase.users;
    }

    public List<UserDto> getAllUserDtos() {
        return getAllUsers().stream().map(this::convertUserToUserDto).collect(Collectors.toList());
    }

    public UserDto getUserDtoById(Integer id) {
        User user = getUserById(id);
        return user!= null ? convertUserToUserDto(user) : null;
    }

    private User getUserById(Integer id) {
        Optional<User> oldUser =  getAllUsers().stream().filter(user -> user.getId().equals(id)).findFirst();
        return oldUser.orElse(null);
    }

    public boolean addUser(UserDto user) {
        return getAllUsers().add(convertUserDtoToUser(user));
    }

    public boolean updateUser (UserDto userDto) {
        boolean isUpdated = false;
        User oldUser = getUserById(userDto.getId());
        User newUser = convertUserDtoToUser(userDto);
        List<User> users = getAllUsers();
        if (oldUser == null) {
            users.add(newUser);
            isUpdated = true;
        } else if (!oldUser.equals(newUser)) {
            users.remove(users.indexOf(oldUser));
            users.add(newUser);
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
