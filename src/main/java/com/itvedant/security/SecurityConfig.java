package com.itvedant.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.itvedant.services.AdminService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	AdminService service;
	
	@Bean
	PasswordEncoder encoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		auth
			.userDetailsService(service)
			.passwordEncoder(encoder());
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		http.csrf().disable()
			.authorizeRequests()
			.antMatchers(HttpMethod.GET,"/superhome").hasAnyRole("SUPER")
			.antMatchers(HttpMethod.GET,"/registeradmin").hasAnyRole("SUPER")
			.antMatchers(HttpMethod.POST,"/addadmin").hasAnyRole("SUPER")
			.antMatchers(HttpMethod.GET,"/updateadmin/**").hasAnyRole("SUPER")
			.antMatchers(HttpMethod.PUT,"/update/**").hasAnyRole("SUPER")
			.antMatchers(HttpMethod.DELETE,"/delete/**").hasAnyRole("SUPER")
			
			
			.antMatchers(HttpMethod.GET,"/adminhome").hasAnyRole("ADMIN")
			.antMatchers(HttpMethod.GET,"/registercustomer").hasAnyRole("SUPER","ADMIN")
			.antMatchers(HttpMethod.POST,"/addcustomer").hasAnyRole("SUPER","ADMIN")
			.antMatchers(HttpMethod.GET,"/updatecustomer/**").hasAnyRole("SUPER","ADMIN")
			.antMatchers(HttpMethod.PUT,"/editcustomer/**").hasAnyRole("SUPER","ADMIN")
			.antMatchers(HttpMethod.DELETE,"/deletecustomer/**").hasAnyRole("SUPER","ADMIN")
			
			
			.antMatchers(HttpMethod.GET,"/").permitAll()
			.antMatchers(HttpMethod.GET,"/registerbook").hasAnyRole("SUPER","ADMIN")
			.antMatchers(HttpMethod.POST,"/addbook").hasAnyRole("SUPER","ADMIN")
			.antMatchers(HttpMethod.GET,"/updatebook/**").hasAnyRole("SUPER","ADMIN")
			.antMatchers(HttpMethod.PUT,"/editbook/**").hasAnyRole("SUPER","ADMIN")
			.antMatchers(HttpMethod.DELETE,"/deletebook/**").hasAnyRole("SUPER","ADMIN")
			
			.and()
			.formLogin()
			.defaultSuccessUrl("/default", true);
			
			
			
			
	}
}
