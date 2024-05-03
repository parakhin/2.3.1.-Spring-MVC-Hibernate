package ru.psy.kataHibernateMVC.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.psy.kataHibernateMVC.models.User;

@Repository
public interface UsersRepository extends JpaRepository<User, Long> {
}
