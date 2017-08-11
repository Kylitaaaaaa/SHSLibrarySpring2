package com.securde.shslibrary.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.securde.shslibrary.model.Resource;
import com.securde.shslibrary.model.User;
import com.securde.shslibrary.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * Created by Thea on 06/08/2017.
 */
@RestController
@RequestMapping(value="/loginuser")
public class LogInController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping(value = "/allAdmin", method = RequestMethod.GET)
    public @ResponseBody
    Iterable<User> allUser() {
        return userRepository.findAll();
    }

    @RequestMapping(value = "/specific/{idnumber}/{password}", method = RequestMethod.POST)
    public User specific(@PathParam(value = "idnumber") @PathVariable int idnumber,
                                        @PathParam(value = "password") @PathVariable String password){
        List<User> uList = userRepository.findAll();
        for(int i=0; i< uList.size(); i++)
            if(uList.get(i).getIdnumber() == idnumber && passwordEncoder.matches(password, uList.get(i).getPassword()))
                return uList.get(i);
        return null;
    }

    @RequestMapping(value = "/isExist/{idnumber}", method = RequestMethod.GET)
    public Boolean isExist(@PathParam(value = "idnumber") @PathVariable int idnumber) {
        User u = userRepository.findUserByIdnumberLike(idnumber);
        if(u == null)
            return false;
        else
            return true;
    }

    @RequestMapping(value = "/getUser/{idnumber}", method = RequestMethod.GET)
    public @ResponseBody User getUser(@PathParam(value = "idnumber") @PathVariable int idnumber) {
        //User u = userRepository.findUserByIdnumberAndPassword(idnumber, password);
        User u  =userRepository.findUserByIdnumberLike(idnumber);
        // userRepository.findAll();
//        if(u == null)
//            return null;
        System.out.println(u.getUsertype());
        return u;
    }


    @RequestMapping(value = "/getAcct/{idnumber}", method = RequestMethod.GET)
    public User getAcct(@PathParam(value = "idnumber") @PathVariable int idnumber) {
        return userRepository.findUserByIdnumberLike(idnumber);
    }


    @RequestMapping(value = "/attempt", method = RequestMethod.POST)
    public User attempt(@RequestBody User user){
        User u = userRepository.findUserByIdnumberLike(user.getIdnumber());
        if(u==null)
         return null;
        if(u != null) {
            if (u.getLockstatus() == 0) {
                if (passwordEncoder.matches(user.getPassword(),u.getPassword()))
                {
                        u.setLoginattempts(0);
                        userRepository.save(u);
                        return u;
                    }

                else {
                    u.setLoginattempts(u.getLoginattempts() + 1);
                    if (u.getLoginattempts() >= 3)
                        u.setLockstatus(1);
                    userRepository.save(u);
                    return null;

                }
            } else
                return null;
        }
        else
            return null;
    }

}
