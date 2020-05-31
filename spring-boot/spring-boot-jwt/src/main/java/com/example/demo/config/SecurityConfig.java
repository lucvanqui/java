package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.filter.JwtTokenFilter;
import com.example.demo.filter.JwtTokenProvider;
import com.example.demo.security.CustomUserDetailService;
import com.example.demo.security.JwtAuthenticationEntryPoint;
import com.example.demo.security.JwtConfigurer;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	JwtTokenProvider jwtTokenProvider;
	@Autowired
	JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
	@Autowired
	JwtTokenFilter jwtTokenFilter;
	@Autowired
	CustomUserDetailService customUserDetailService;

	@Bean
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder  auth) throws Exception {
		auth.userDetailsService(customUserDetailService).passwordEncoder(passwordEncoder());
	}
	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
				.antMatchers("/token/create").permitAll()
				.anyRequest().authenticated()
				.and()
				.exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint)
				.and()
				.apply(new JwtConfigurer(jwtTokenProvider));

	}

}
