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
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;



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

    @RequestMapping(value = "/unlockUser/{uid}/{currPrev}", method = RequestMethod.POST)
    public @ResponseBody
    Iterable <User> unlockUser(@PathParam(value = "uid") @PathVariable int uid,
                               @PathParam(value = "currPrev") @PathVariable int currPrev) {
        User u = userRepository.findOne(uid);
        u.setLockstatus(0);
        u.setLoginattempts(0);
        userRepository.save(u);
        return userRepository.findUserByUsertypeLike(currPrev);
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