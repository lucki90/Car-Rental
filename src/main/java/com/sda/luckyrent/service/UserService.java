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

    public User create(User user, BindingResult bindingResult) {
        validateUser(user, bindingResult);
        return userRepository.save(user);
    }

    public User getById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (!user.isPresent()) {
            throw new NotFoundException(String.format("User with id %s does not exist", id));
        }
        return user.get();
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User update(Long id, User user, BindingResult bindingResult) {
        User dbUser = getById(id);
        validateUser(user, bindingResult);
        dbUser.updateForm(user);
        return userRepository.save(dbUser);
    }

    public void delete(Long id) {
        if (!userRepository.existsById(id)) {
            throw new NotFoundException(String.format("User with id %s does not exist", id));
        }
        userRepository.deleteById(id);
    }

    private void validateUser(User user, BindingResult bindingResult) {
        if (userRepository.existsByPhoneNumber(user.getPhoneNumber())) {
            bindingResult.addError(
                    new FieldError("user", "phoneNumber",
                            String.format("User with this phone number %s already exists", user.getPhoneNumber())));
        }
        if (bindingResult.hasErrors()) {
            throw new BindingResultException(bindingResult);
        }
    }
}
