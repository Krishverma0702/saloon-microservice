package com.saloon.userService.service.impl;

import com.saloon.userService.exception.UserException;
import com.saloon.userService.model.User;
import com.saloon.userService.repository.UserRepository;
import com.saloon.userService.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Integer id) throws UserException {
        Optional<User> byId = userRepository.findById(id);

        if (byId.isPresent()) {
            return byId.get();
        }

        throw new UserException("user not found");
    }

    @Override
    public void deleteUserById(Integer id) throws UserException {
        Optional<User> byId = userRepository.findById(id);
        if (byId.isEmpty()) {
            throw new UserException("User not found with id" + id);
        }
        userRepository.deleteById(byId.get().getId());
    }

    @Override
    public User updateUser(Integer id, User user) throws UserException {
        Optional<User> byId = userRepository.findById(id);

        if (byId.isEmpty()) {
            throw new UserException("User not present with id " + id);
        }

        User user1 = byId.get();
        user.setFullName(user.getFullName());
        user.setEmail(user.getEmail());
        user.setPhone(user.getPhone());
        user.setRole(user.getRole());
        user.setUsername(user.getUsername());

        return userRepository.save(user1);
    }
}
