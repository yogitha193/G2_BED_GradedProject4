package com.gl.EmployeeManagementRest.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.gl.EmployeeManagementRest.service.UserService;
import com.gl.EmployeeManagementRest.service.UserServiceImpl;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserService userService;

	@Bean
	public UserDetailsService userDetailsService() {
		return new UserServiceImpl();
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userService);
		authProvider.setPasswordEncoder(passwordEncoder());
		return authProvider;
	}

	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/employees/save", "/employees/update", "/employees/delete/{employeeId}")
		.hasAuthority("ADMIN")
		// only ADMIN is authorized to add employee,update the employee and delete the
		// employee

		.antMatchers("/registration", "/registration/save", "/employees/list", "/employees/view/{id}",
				"/roles/save", "/employees/sort", "/employees/search/{keyword}")
		.permitAll()
		// anyone is authorized to perform the above actions

		.anyRequest().authenticated().and().httpBasic()
		// to perform BasicAuth in Post man

		.and().cors().and().csrf().disable();
	}
}
