package ru.psy.kataHibernateMVC.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.psy.kataHibernateMVC.models.User;
import ru.psy.kataHibernateMVC.repositories.UsersRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {
    private final UsersRepository usersRepository;

    @Autowired
    public UserServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public List<User> findAll() {
        return usersRepository.findAll();
    }

    @Override
    public User findOne(int id) {
        return usersRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void save(User user) {
        usersRepository.save(user);
    }

    @Override
    @Transactional
    public void update(int id, User user) {
        user.setId(id);
        usersRepository.save(user);
    }

    @Override
    @Transactional
    public void delete(int id) {
        usersRepository.deleteById(id);
    }
}
