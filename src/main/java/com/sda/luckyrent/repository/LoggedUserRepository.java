package com.sda.luckyrent.repository;

import com.sda.luckyrent.model.LoggedUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoggedUserRepository extends JpaRepository<LoggedUser, Long> {

    List<LoggedUser> findByLoginContaining(String login);

}
