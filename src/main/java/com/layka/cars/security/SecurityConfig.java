package com.layka.cars.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public UserDetailsService userDetailsService(DataSource dataSource) {
//        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
//
//        jdbcUserDetailsManager.setUsersByUsernameQuery("select username, password, enabled from users where username=?");
//        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select username, authority from authorities where username=?");
//
//        return jdbcUserDetailsManager;
//    }

    @Bean
	 SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {      
		 	 http.authorizeHttpRequests((requests)->requests
	                		.requestMatchers("/showCreate", "/saveCar").hasAnyAuthority("ADMIN", "AGENT")
	                		.requestMatchers("/ListeCars").hasAnyAuthority("ADMIN","AGENT","USER")
	                		.requestMatchers("/login","/webjars/**").permitAll()
	                		.anyRequest().authenticated())
                  	                
	                .formLogin((formLogin) ->   formLogin
	                		 		.loginPage("/login")
	                		 		.defaultSuccessUrl("/") )
	                
	                .httpBasic(Customizer.withDefaults())
	                .exceptionHandling((exception)-> exception.accessDeniedPage("/accessDenied"));
	        return http.build();
	    }

}
