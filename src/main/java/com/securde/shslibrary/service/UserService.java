package com.securde.shslibrary.service;

import com.securde.shslibrary.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by Bryan on 8/8/2017.
 */
@Service("userDetailsService")
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findUserByIdnumberLike(Integer.parseInt(username));
//        System.out.println("s"+s.getPassword() + " " + s.getUsername());
//        return s;
    }
}