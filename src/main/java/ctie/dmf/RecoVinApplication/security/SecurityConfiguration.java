package ctie.dmf.RecoVinApplication.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import ctie.dmf.RecoVinApplication.filters.JwtRequestFilter;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private JwtRequestFilter jwtRequestFilter;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userDetailsService);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests()
			.antMatchers("/admin","adminPage").hasRole("ADMIN")
			.antMatchers("/user","/welcomePage").hasAnyRole("ADMIN","USER")
			.antMatchers("/error","/login","/newWine","/newWinetype").permitAll()
			.and().formLogin();
		http.csrf().disable().authorizeRequests()
		.antMatchers("/authenticate",
				"/getWineTypes","/getWineTypesByName","/getWineTypeById",
				"/getProducers","/getProducersByName","/getProducerById",
				"/getWines","/getWinesByType").permitAll()
		.antMatchers("/newWineType","/newProducer").hasRole("ADMIN")
		.anyRequest().authenticated()
		.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		http.addFilterBefore(jwtRequestFilter,UsernamePasswordAuthenticationFilter.class);
	}
	
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception{
		return super.authenticationManagerBean();
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
