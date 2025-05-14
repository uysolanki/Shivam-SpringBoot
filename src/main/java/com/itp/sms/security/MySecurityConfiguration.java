package com.itp.sms.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class MySecurityConfiguration extends WebSecurityConfigurerAdapter
{
	
//achieve Authentication
@Override
protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//	 auth.inMemoryAuthentication()
//		.withUser("jethalal")
//		.password("jetha123")		// cleartext
//		.authorities("ADMIN")
//		.and()
//		.withUser("bagha")
//		.password("bagha123")		// cleartext
//		.authorities("USER");
	
	auth.authenticationProvider(myITPAuthenticationCode());
}

@Bean
public AuthenticationProvider myITPAuthenticationCode() {
	DaoAuthenticationProvider daoAuth=new DaoAuthenticationProvider();
	daoAuth.setUserDetailsService(myITPUserDetail());
	daoAuth.setPasswordEncoder(myITPPassword());
	return daoAuth;
}

@Bean
public PasswordEncoder myITPPassword() {
	return new BCryptPasswordEncoder();
}

@Bean
public UserDetailsService myITPUserDetail() 
{
	return new MyUserDetailsService();
}

//@Bean
//public PasswordEncoder getPasswordEncoder()
//{
//	return NoOpPasswordEncoder.getInstance();
//}


//achieve Authorisation
@Override
	protected void configure(HttpSecurity http) throws Exception {
//	http.authorizeRequests()
//    .anyRequest()
//    .authenticated()
//    .and()        
//    .formLogin().loginProcessingUrl("/login").successForwardUrl("/home").permitAll()
//    .and()
//    .cors().and().csrf().disable();
	
	
    http.authorizeRequests()
    .antMatchers("/home","/addplayer","/403").hasAnyAuthority("USER","ADMIN")
    .antMatchers("/deletePlayer/**","/updatePlayerForm/**").hasAuthority("ADMIN")
    .anyRequest().authenticated()
    .and()
    .formLogin().loginProcessingUrl("/login").successForwardUrl("/home").permitAll()
    .and()
    .logout().logoutSuccessUrl("/login").permitAll()
    .and()
    .exceptionHandling().accessDeniedPage("/403")
    .and()
    .cors().and().csrf().disable();

	}
}
