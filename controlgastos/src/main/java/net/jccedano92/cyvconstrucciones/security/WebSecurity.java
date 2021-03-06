package net.jccedano92.cyvconstrucciones.security;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import net.jccedano92.cyvconstrucciones.services.UserServiceInterface;

@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter{

	
	private final UserServiceInterface userService;
	private final BCryptPasswordEncoder bCryptPassword;
	
	public WebSecurity(UserServiceInterface userService, BCryptPasswordEncoder bCryptPassword) {
		this.userService = userService;
		this.bCryptPassword = bCryptPassword;
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers(HttpMethod.POST, "/users").permitAll()
			.anyRequest().authenticated().and().addFilter(new AuthenticationFilter(authenticationManager()))
			.addFilter(new AuthorizationFilter(authenticationManager()))
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS); 
	}
	
	@Override
	public void configure( AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService).passwordEncoder(bCryptPassword);  //decimos que el password encodersera de tipo bCryptPassword en el detalle de servicio de usuario (debemos extender ese metodo en UserServiceInterface y sobreescribirlo en UserService
	}
	
	
	
}
