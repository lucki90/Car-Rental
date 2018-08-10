package com.sda.luckyrent.controller;

import com.sda.luckyrent.model.User;
import com.sda.luckyrent.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User create (@RequestBody @Valid User user, BindingResult bindingResult) {
        return userService.create(user,bindingResult);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<User> getAll(){
        return userService.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User getById(@PathVariable Long id){
        return userService.getById(id);
    }

    @GetMapping("/{name}")
    @ResponseStatus(HttpStatus.OK)
    public User getById(@PathVariable String name){
        return userService.getByName(name);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        userService.delete(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public User update(@PathVariable Long id,
                       @RequestBody @Valid User user,
                       BindingResult bindingResult){
        return userService.update(id,user,bindingResult);
    }

}
