package br.com.ilsc.siteblog;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/index", "/bloghome/**", "/textoDoBlog/**").permitAll().anyRequest()
				.authenticated().and()
				.formLogin(form -> form.loginPage("/login").defaultSuccessUrl("/usuario/blogs", true).permitAll())
				.logout(logout -> logout.logoutUrl("/logout").logoutSuccessUrl("/bloghome")).csrf().disable();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(encoder);
	}

//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//
//		UserDetails user = User.builder().username("maria").password(encoder.encode("123")).roles("ADM").build();
//
//		auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(encoder).withUser(user);
//	}

}
