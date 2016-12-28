package com.chappal.foot.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration 
{
	@Autowired
	DataSource dataSource;
	
	public void configUser(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception
	{
		authenticationManagerBuilder.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery("select user_Name,user_Password,status from User where user_Name = ?;").authoritiesByUsernameQuery("Select u.user_Name , r.role_Name from UserDetail u join Role r where r.role_Id = 1 and u.user_Name = ?;");
	}	
	protected void configuration(HttpSecurity httpSecurity) throws Exception
	{
		httpSecurity.authorizeRequests().antMatchers("/Foot/").access("hasRole('USER')").and().formLogin().loginPage("/loginform").failureUrl("/login?error").usernameParameter("username").passwordParameter("password").loginProcessingUrl("/perform_login").defaultSuccessUrl("/Foot/").and().logout().logoutSuccessUrl("/perform_logout").invalidateHttpSession(true).and().csrf().disable();
	}
}
