package com.securde.shslibrary.controller;

import com.securde.shslibrary.model.RandomStringGenerator;
import com.securde.shslibrary.model.User;
import com.securde.shslibrary.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping(value="/gen")
public class GenController {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;



    @RequestMapping(value = "/allAdmin", method = RequestMethod.GET)
    public @ResponseBody
    Iterable<User> getAllAdmin() {
        return userRepository.findAll();

    }


    @RequestMapping(value = "/type/{type}", method = RequestMethod.GET)
    public @ResponseBody
    Iterable <User> getLibMans(@PathParam(value = "type") @PathVariable int type) {
        return userRepository.findUserByUsertypeLike(type);
    }

    @RequestMapping(value = "/unlockUser/{uid}", method = RequestMethod.GET)
    public @ResponseBody
    Iterable <User> unlockUser(@PathParam(value = "uid") @PathVariable int uid) {
        User u = userRepository.findOne(uid);
        u.setLockstatus(0);
        u.setLoginattempts(0);
        userRepository.save(u);
        return userRepository.findAll();
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public @ResponseBody
    Iterable <User> create(@RequestBody User user){

        RandomStringGenerator gen = new RandomStringGenerator();
        user.setPassword(passwordEncoder.encode(gen.genString(10)));
        user.setSecretanswer(passwordEncoder.encode(user.getSecretanswer()));
        userRepository.save(user);


       return  userRepository.findAll();
    }





}