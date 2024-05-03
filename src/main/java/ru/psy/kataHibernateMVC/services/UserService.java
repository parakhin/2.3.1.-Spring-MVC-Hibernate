package ru.psy.kataHibernateMVC.services;

import ru.psy.kataHibernateMVC.models.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findOne(int id);

    void save(User user);

    void update(int id, User user);

    void delete(int id);
}
