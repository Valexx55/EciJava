package edu.eci;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration // para que cargue esta clase al inicio
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	

	// 1 definimos usuarios y roles
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("user1").password("{noop}user1") // lo de {noop} se pone para no obligar a usar mecanismo de encriptación
				.roles("USER").and().withUser("admin").password("{noop}admin").roles("USER", "ADMIN");

		/*
		 * lo siguiente sería para el caso de que quisiéramos encriptar la password:
		 * String pw1=new BCryptPasswordEncoder().encode("user1");
		 * System.out.println(pw1); auth .inMemoryAuthentication() .withUser("user1")
		 * .password("{bcrypt}"+pw1) //.password(pw1) .roles("USER") .and()
		 * .withUser("admin") .password(new BCryptPasswordEncoder().encode("admin"))
		 * .roles("USER", "ADMIN");
		 * 
		 * 
		 * /*la seguiente configuración será para el caso de usuarios en una base de
		 * datos auth.jdbcAuthentication().dataSource(datasourceSecurity)
		 * .usersByUsernameQuery("select username, password, enabled" +
		 * " from users where username=?")
		 * .authoritiesByUsernameQuery("select username, authority " +
		 * "from authorities where username=?");
		 */
	}

	// 2 método que define las POLÍTICAS de SEGURIDAD
	// definición de políticas de seguridad
    @Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
				// solo los miembros del rol admin podrán borrar alumnos
				//MODIFICAMOS LA SEGURIDAD PARA QUE SÓLO PIDA autenticación en este caso 
				.antMatchers(HttpMethod.DELETE, "/alumno/*").hasRole("ADMIN")
				// con un *, se protege una dirección que venga con un elemento más. Con dos *,
				// se protegen
				// todas las direcciones, que vengan con cualquier número de datos adicionales o
				// ninguno
				// .antMatchers("/api/alumnos/**").authenticated()

				.and().httpBasic();

	}
}