package com.denistech.jwt.api.repository;

import com.denistech.jwt.api.entity.User;

import java.util.List;

public interface UserRepository {

    User findByUsername(String username);

    public void createUser(User user);

    public void saveAll(List<User> users);

    public void clear();
}
