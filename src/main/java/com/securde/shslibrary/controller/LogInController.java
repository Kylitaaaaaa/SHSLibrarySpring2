package com.securde.shslibrary.controller;

import com.securde.shslibrary.model.User;
import com.securde.shslibrary.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

/**
 * Created by Thea on 06/08/2017.
 */
@RestController
@RequestMapping(value="/logincontroller")
public class LogInController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/isExist/{idnumber}", method = RequestMethod.GET)
    public Boolean isExist(@PathParam(value = "idnumber") @PathVariable int idnumber) {
        User u = userRepository.findUserByIdnumberLike(idnumber);
        if(u == null)
            return false;
        else
            return true;
    }

    @RequestMapping(value = "/getAcct/{idnumber}", method = RequestMethod.GET)
    public User getAcct(@PathParam(value = "idnumber") @PathVariable int idnumber) {
        return userRepository.findUserByIdnumberLike(idnumber);
    }


    @RequestMapping(value = "/attempt", method = RequestMethod.POST)
    public User attempt(@RequestBody User user){
        User u = userRepository.findUserByIdnumberLike(user.getIdnumber());
        if(u != null) {
            if (u.getLockstatus() == 1) {
                if (u.getPassword().equals(user.getPassword()))
                    return u;
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
