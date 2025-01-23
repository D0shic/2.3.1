package com.d0sk.service;

import com.d0sk.models.User;

import java.util.List;

public interface UserService {
    void add(User user);
    void delete(Long id);
    void update(User user);
    List<User> listUsers();
    User findById(Long id);
}
