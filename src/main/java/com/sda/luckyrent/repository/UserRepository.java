package com.sda.luckyrent.repository;

import com.sda.luckyrent.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByName(String name);
    Boolean existsByPhoneNumber(Integer number);

}
