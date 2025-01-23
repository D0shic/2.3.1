package com.d0sk.dao;

import com.d0sk.models.User;

import java.util.List;

public interface UserDAO {
    void add(User user);
    void delete(Long id);
    void update(User user);
    List<User> listUsers();
    User findById(Long id);
}
