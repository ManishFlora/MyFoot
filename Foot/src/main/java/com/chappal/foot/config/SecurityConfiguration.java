package com.chappal.foot.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter 
{
	@Autowired
	DataSource dataSource;
	
	@Autowired
	public void configUser(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception
	{
		authenticationManagerBuilder.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery("select userName,userPassword,status from User where userName = ?;").authoritiesByUsernameQuery("Select u.userName , r.roleName from User u , Role r, UserRole ur where u.userId = ur.userId and r.roleId = ur.roleId and userName = ?;");
	}	
	
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception
	{
		httpSecurity.authorizeRequests()
		.antMatchers("/categoryform","/subcategoryform","/brandform","/productsform","/supplierform").access("hasRole('ROLE_ADMIN')")
		.antMatchers("/buyNow-{productsId}","/addToCart-{productsId}","/cartItems","/wishList-{productsId}","/wishListItems").access("hasRole('ROLE_USER')")
		.antMatchers("/productssupplierform-{userId}").access("hasRole('ROLE_SUPPLIER')")
		.anyRequest().permitAll()
		.and()
		.formLogin().loginPage("/login").failureUrl("/login?error").usernameParameter("username").passwordParameter("password").loginProcessingUrl("/perform_login").defaultSuccessUrl("/").and().logout().logoutSuccessUrl("/").and().exceptionHandling().accessDeniedPage("/403").and().csrf().disable();
	}
}