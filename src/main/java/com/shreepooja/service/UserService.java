package com.shreepooja.service;

import com.shreepooja.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void createUser(User user);
    Optional<User> getUser(String userId);
    List<User> getUsers();
    void deleteUser(String userId);
}
