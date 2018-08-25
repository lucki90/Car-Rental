package com.sda.luckyrent.controller;

import com.sda.luckyrent.model.LoggedUser;
import com.sda.luckyrent.service.LoggedUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/logged-users")
public class LoggedUserController {

    @Autowired
    private LoggedUserService loggedUserService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public LoggedUser create(@RequestBody LoggedUser loggedUser){
        return loggedUserService.create(loggedUser);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<LoggedUser> search(
            @RequestParam(value = "login", required = false, defaultValue = "") String login){
      return loggedUserService.search(login);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public LoggedUser getById(@PathVariable Long id){
        return loggedUserService.getById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        loggedUserService.delete(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public LoggedUser update(@PathVariable Long id,
                             @RequestBody @Valid LoggedUser loggedUser,
                             BindingResult bindingResult){
        return loggedUserService.update(id,loggedUser,bindingResult);
    }
}
