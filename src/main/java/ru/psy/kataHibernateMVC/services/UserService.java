package ru.psy.kataHibernateMVC.services;

import ru.psy.kataHibernateMVC.models.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findOne(Long id);

    void save(User user);

    void update(Long id, User user);

    void delete(Long id);
}
