package org.example.service;

import org.example.entity.User;

public interface UserService {
    void create(User user);
    User read(Long id);
    void update(User user);
    void delete(User user);
}
