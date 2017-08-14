package com.securde.shslibrary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;


/**
 * Created by Thea on 03/08/2017.
 */
@Controller
@RequestMapping("/")
public class ViewController {

    @RequestMapping("/user")
    public Principal user(Principal user) {
        System.out.println("AS /user has been called");
        System.out.println("user info: "+user.toString());
        return user;
    }

    @RequestMapping("/login")
    public String login (Model model){
        return "login";
    }

    @RequestMapping("/dashboard")
    public String dashboard (Model model){
        return "dashboard";
    }

    @RequestMapping("/admin")

    public String admin(Model model){
        return "admin";
    }

    @RequestMapping("/libman")
    public String libman(Model model){
        return "libmanpage";
    }

    @RequestMapping("/libstaff")
    public String libstaff(Model model){
        return "libstaffpage";
    }

    @RequestMapping("/customer")
    public String customer(Model model){
        return "customer";
    }
}
