package com.saloon.userService.service;

import com.saloon.userService.exception.UserException;
import com.saloon.userService.model.User;

import java.util.List;

public interface UserService {
    User createUser(User user);

    List<User> getAllUsers();

    User getUserById(Integer id) throws UserException;

    void deleteUserById(Integer id) throws UserException;

    User updateUser(Integer id, User user) throws UserException;
}
