package com.securde.shslibrary.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;

/**
 * Created by Bryan on 7/23/2017.
 */

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter{

    public static final String RESOURCE_ID = "shslibrary_v1";

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    @Qualifier("userDetailsService")
    private UserDetailsService userDetailsService;

    @Value("${shslibrary.oauth.tokenTimeout:3600}")
    private int expiration;


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        super.configure(security);
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//        clients.jdbc(null)
//                .withClient("sampleClientId")
//                .authorizedGrantTypes("implicit")
//                .scopes("read")
//                .autoApprove(true)
//                .and()
//                .withClient("clientIdPassword")
//                .secret("secret")
//                .authorizedGrantTypes(
//                        "password","authorization_code", "refresh_token")
//                .scopes("read");
        clients.inMemory()
                .withClient("service-account-1")
                .secret("service-account-1-secret")
                .authorizedGrantTypes("client_credentials")
                .scopes("resource-server-read", "resource-server-write").and()
                .withClient("gigy").secret("secret").accessTokenValiditySeconds(expiration)
                .scopes("read", "write").authorizedGrantTypes("password", "refresh_token").resourceIds(RESOURCE_ID);
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager);
        endpoints.userDetailsService(userDetailsService);
    }

//    @Bean
//    public TokenStore tokenStore() {
//        return new JdbcTokenStore(dataSource());
//    }
//
//    @Bean
//    public DataSourceInitializer dataSourceInitializer(DataSource dataSource) {
//        DataSourceInitializer initializer = new DataSourceInitializer();
//        initializer.setDataSource(dataSource);
//        initializer.setDatabasePopulator(databasePopulator());
//        return initializer;
//    }
//
//    private DatabasePopulator databasePopulator() {
//        ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
//        populator.addScript(schemaScript);
//        return populator;
//    }
//
//    @Bean
//    public DataSource dataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
//        dataSource.setUrl(env.getProperty("jdbc.url"));
//        dataSource.setUsername(env.getProperty("jdbc.user"));
//        dataSource.setPassword(env.getProperty("jdbc.pass"));
//        return dataSource;
//    }

}
