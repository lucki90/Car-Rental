package com.sda.luckyrent.service;

import com.sda.luckyrent.exception.BindingResultException;
import com.sda.luckyrent.exception.NotFoundException;
import com.sda.luckyrent.model.User;
import com.sda.luckyrent.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (!user.isPresent()) {
            throw new NotFoundException(String.format("User with id %s does not exist", id));
        }
        return user.get();
    }

    public User getByName(String name) {
        User user = userRepository.findByName(name);
        if (user == null) {
            throw new NotFoundException(String.format("User with name %s does not exist", name));
        }
        return user;
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User create(User user, BindingResult bindingResult) {

        validateUser(user, null, bindingResult);
        return userRepository.save(user);
    }

    public void delete(Long id) {
        if (userRepository.existsById(id)) {
            throw new NotFoundException(String.format("User with id %s does not exist", id));
        }
        userRepository.deleteById(id);
    }

    public User update(Long id, User user, BindingResult bindingResult) {
        Optional<User> savedUser = userRepository.findById(id);
        if (!savedUser.isPresent()){
            throw new NotFoundException(String.format("User with id %s does not exists", id));
        }
        User dbUser = savedUser.get();

        validateUser(user, dbUser, bindingResult);

        dbUser.updateForm(user);
        return userRepository.save(dbUser);

    }

    private void validateUser(User user, User currentUser, BindingResult bindingResult) {
        if (user.getName().equals(currentUser.getName())
                && userRepository.findByName(user.getName()) != null) {
            bindingResult.addError(
                    new FieldError("user", "field",
                            String.format("User with username %s already exists", user.getName())));
        }
        if (bindingResult.hasErrors()) {
            throw new BindingResultException(bindingResult);
        }
    }

}
