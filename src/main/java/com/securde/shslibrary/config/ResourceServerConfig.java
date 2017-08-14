package com.securde.shslibrary.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.token.DefaultToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.security.Principal;
import java.util.*;

/**
 * Created by Bryan on 7/23/2017.
 */
@Configuration
@RestController
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter{

    @Resource(name="tokenStore")
    TokenStore tokenStore;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.resourceId(AuthorizationServerConfig.RESOURCE_ID).tokenStore(tokenStore);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/tokens")
    @ResponseBody
    public List<String> getTokens() {
        List<String> tokenValues = new ArrayList<String>();
        Collection<OAuth2AccessToken> tokens = tokenStore.findTokensByClientId("customer");
        if (tokens!=null){
            for (OAuth2AccessToken token:tokens){
                tokenValues.add(token.getValue());
            }
        }
        return tokenValues;
    }

    @Autowired
    DefaultTokenServices tokenServices;

    @RequestMapping(method = RequestMethod.POST, value = "/tokens/revoke/{tokenId:.*}")
    @ResponseBody
    public String revokeToken(@PathVariable String tokenId) {
        System.out.println("------------------------------------------------");
        System.out.println(tokenId);
        System.out.println("------------------------------------------------"+tokenServices==null);
        tokenServices.revokeToken(tokenId);
        return tokenId;
    }

    @RequestMapping("/user")
    public Principal user(Principal user) {
        System.out.println("AS /user has been called");
        System.out.println("user info: "+user.toString());
        return user;
    }

    @RequestMapping("/userid")
    public Principal userid(Principal user) {
        System.out.println("AS /user has been called");
        System.out.println("user info: "+user.getName());
        return user;
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/home", "/register", "/login").permitAll()
                //.antMatchers("/","/gen/**","/libman/**", "/libstaff/**", "/customer/**").authenticated()
//                .antMatchers("/","/gen/**","/libman/**", "/libstaff/**").authenticated()
                //.antMatchers("/gen/**").access("#oauth2.hasScope('ADMIN')")
                .antMatchers("/libman/**").access("#oauth2.hasScope('LIBMAN')")
                .antMatchers("/libstaff/**").access("#oauth2.hasScope('LIBSTAFF')")
                .antMatchers("/customer/**").access("#oauth2.hasScope('CUSTOMER')")
        ;//.antMatchers("/customer/**");
    }


}
