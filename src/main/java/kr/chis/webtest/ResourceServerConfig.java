package kr.chis.webtest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.web.server.SecurityWebFilterChain;

/**
 * @author InSeok
 * Date : 2020-08-14
 * Remark :
 */
@EnableWebFluxSecurity
//@EnableResourceServer
//@Configuration
public class ResourceServerConfig{// extends ResourceServerConfigurerAdapter {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http){
        http.httpBasic().disable();
        http.formLogin().disable();
        http.csrf().disable();
        http.logout().disable();


        http.authorizeExchange()
                .pathMatchers("/**").authenticated()
                .and()
                .oauth2ResourceServer().jwt();


        return http.build();
    }

//
//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//        http.headers().frameOptions().disable();
//        http.authorizeRequests()
//                .antMatchers("/").access("#oauth2.hasScope('read')")
//                .anyRequest().authenticated();
//    }
}
