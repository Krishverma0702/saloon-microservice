package com.project.saloonApplication.service;

import com.project.saloonApplication.exception.UserException;
import com.project.saloonApplication.model.User;

import java.util.List;

public interface UserService {

    User createUser(User user);

    List<User> getAllUsers();

    User getUserById(int id) throws UserException;

    void deleteUserById(int id) throws UserException;

    User updateUser(int id, User user) throws UserException;
}
