package br.com.farmacia10.seguranca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity /*Habilitar a configuração de web security com a anotação '@EnableWebSecurity' e estender a classe com o WebSecurityConfigurerAdapter*/
public class BasicSecurityConfig extends WebSecurityConfigurerAdapter { 
	
	/*Métodos*/
	@Autowired
	private UserDetailsService userDetailsService; /*classe que existe dentro de WebSecurityConfigurerAdapter*/
	
	@Override /*Sobreescrita de método*/
	protected void configure(AuthenticationManagerBuilder auth) throws Exception { /*throws Exception: Tratativa de erros*/
		auth.userDetailsService(userDetailsService); 
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override /*Sobreescrita de método*/
	protected void configure(HttpSecurity http) throws Exception{ /*throws Exception: Tratativa de erros*/
		http.authorizeRequests()
		.antMatchers("/usuarios/logar").permitAll()
		.antMatchers("/usuarios/cadastrar").permitAll()
		.anyRequest().authenticated()
		.and().httpBasic()
		.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) /*STATELESS: Não Guarda sessão*/
		.and().cors()
		.and().csrf().disable();
	}
	
}
