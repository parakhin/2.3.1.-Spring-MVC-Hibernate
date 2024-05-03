package ru.psy.kataHibernateMVC.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.psy.kataHibernateMVC.models.User;
import ru.psy.kataHibernateMVC.repositories.UsersRepository;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UsersRepository usersRepository;

    @Autowired
    public UserServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return usersRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public User findOne(Long id) {
        return usersRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void save(User user) {
        usersRepository.save(user);
    }

    @Override
    @Transactional
    public void update(Long id, User user) {
        user.setId(id);
        usersRepository.save(user);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        usersRepository.deleteById(id);
    }
}
