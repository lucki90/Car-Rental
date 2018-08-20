package com.sda.luckyrent.service;

import com.sda.luckyrent.exception.BindingResultException;
import com.sda.luckyrent.exception.NotFoundException;
import com.sda.luckyrent.model.LoggedUser;
import com.sda.luckyrent.repository.LoggedUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.Optional;

@Service
public class LoggedUserService {

    @Autowired
    private LoggedUserRepository loggedUserRepository;

    public LoggedUser create(LoggedUser loggedUser){
        return loggedUserRepository.save(loggedUser);
    }

    public LoggedUser getById(Long id){
        Optional<LoggedUser> loggedUser = loggedUserRepository.findById(id);
        if (!loggedUser.isPresent()) {
            throw new NotFoundException(String.format("Logged user with id %s does not exists",id));
        }
        return loggedUser.get();
    }

    public List<LoggedUser> search(String login){
        return loggedUserRepository.findByLoginContaining(login);
    }

    public void delete(Long id){
        if (!loggedUserRepository.existsById(id)){
            throw new NotFoundException(String.format("Logged user with id %s does not exists",id));
        }
        loggedUserRepository.deleteById(id);
    }

    public LoggedUser update(Long id, LoggedUser loggedUser, BindingResult bindingResult){
        LoggedUser dbLoggedUser = getById(id);
        loggedUser.setId(id);
        validateCar(bindingResult);
        dbLoggedUser.updateFrom(dbLoggedUser);
        return loggedUserRepository.save(dbLoggedUser);
    }

    private void validateCar(BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new BindingResultException(bindingResult);
        }
    }

}
