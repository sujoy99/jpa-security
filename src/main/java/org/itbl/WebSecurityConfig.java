package org.itbl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsPasswordService;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	UserDetailsService userDetailsService;
	
	
//	@Autowired
//	CustomPasswordEncoder customPasswordEncoder; 
	
	@Bean
	AuthenticationProvider authenticationProvider() {
		
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(encoder());
//		provider.setPasswordEncoder(new CustomPasswordEncoder());
//		provider.setPasswordEncoder(gePasswordEncoder());
		
//		System.out.println(provider);
		
		return provider;
	}
	
	
	
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
//		http.authorizeRequests()
//			.antMatchers("/")
//			.permitAll()
//			.antMatchers("/admin","/test")
//			.hasAuthority("1")
//			.antMatchers("/bida")
//			.hasAuthority("2")
//			.and()
//			.formLogin()
//			.loginPage("/login")
//			.permitAll()
//			.and()
//			.exceptionHandling().accessDeniedPage("/login")
//			.and()
//			.httpBasic();
		
//		http.authorizeRequests()
//			
//			.antMatchers("/bida")
//			.hasAuthority("2")
//			.anyRequest()
//			.authenticated()
//			.and()
//			.formLogin()
//			.loginPage("/login")
//			.defaultSuccessUrl("/test")
//			.permitAll()
//			.and()
//			.exceptionHandling().accessDeniedPage("/login")
//			.and()
//			.httpBasic();
		
		/*
		 * http.authorizeRequests()
		 *  .antMatchers("/**")
		 *  .permitAll() // means access all
		 * url without login 
		 * .and() 
		 * .formLogin() 
		 * .loginPage("/login")
		 *  .and()
		 *   .logout();
		 */
			
		http.authorizeRequests()
			.antMatchers("/bida", "/test")
			.hasAuthority("2")
			.antMatchers("/**").hasAnyAuthority("1", "2")
			.and()
			.formLogin()
			.loginPage("/login")
			.permitAll()
			.and()
			.logout();
	
	}





	@Bean
	public PasswordEncoder encoder() {
	    return new BCryptPasswordEncoder();
	}
	
	/*
	 * without encrytion, text to text match
	 * 
	 * @Bean public PasswordEncoder gePasswordEncoder() { return
	 * NoOpPasswordEncoder.getInstance(); }
	 */

}
