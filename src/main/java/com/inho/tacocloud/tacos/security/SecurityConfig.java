package com.inho.tacocloud.tacos.security;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final DataSource dataSource;

    public static final String DEF_USERS_BY_USERNAME_QUERY = "select username,password, enabled " +
                                                            "from users " +
                                                            "where username = ?";
    public
    static final String DEF_AUTHORITIES_BY_USERNAME_QUERY = "select username, authority " +
                                                            "from authorities " +
                                                            "where username = ?";
    public static final String DEF_GROUP_AUTHORTIEIS_BY_USERNAME_QUERY = "select g.id, g.group_name, ga.authority " +
            "from authorities B,group-membersgn, group authorities ga " +
            "where gm.username = ? " +
            "and g.id = ga.group_id " +
            "and g.id = gm.group_id";

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/design", "/orders")
                .access("hasRole('ROLE_USER')")
                .antMatchers("/", "/**").access("permitAll()")
                .and()
                .httpBasic();
    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("user1")
//                .password("{noop}password1")
//                .authorities ("ROLE_USER")
//                .and()
//                .withUser("user2")
//                .password("{noop}password2")
//                .authorities ("ROLE_USER");
//    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource);
    }

}
