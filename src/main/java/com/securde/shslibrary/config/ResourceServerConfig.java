package com.securde.shslibrary.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Collections;
import java.util.Map;

/**
 * Created by Bryan on 7/23/2017.
 */
@Configuration
@RestController
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter{
    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.resourceId(AuthorizationServerConfig.RESOURCE_ID);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/home", "/register", "/login").permitAll()
                //.antMatchers("/","/gen/**","/libman/**", "/libstaff/**", "/customer/**").authenticated()
                .antMatchers("/","/gen/**","/libman/**", "/libstaff/**").authenticated()
                .antMatchers("/gen/**").access("#oauth2.hasScope('ADMIN')")
                .antMatchers("/libman/**").access("#oauth2.hasScope('LIBMAN')")
                .antMatchers("/libstaff/**").access("#oauth2.hasScope('LIBSTAFF')")
                //.antMatchers("/customer/**").access("#oauth2.hasScope('CUSTOMER')")
        ;//.antMatchers("/customer/**");
    }
}
