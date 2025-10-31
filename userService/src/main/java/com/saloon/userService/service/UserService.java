package com.saloon.userService.service;

import com.saloon.userService.exception.UserException;
import com.saloon.userService.model.User;

import java.util.List;

public interface UserService {
    User createUser(User user);

    List<User> getAllUsers();

    User getUserById(int id) throws UserException;

    void deleteUserById(int id) throws UserException;

    User updateUser(int id, User user) throws UserException;
}
