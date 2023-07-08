package br.gov.mds.sisConferencia.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

/**
 *
 * @author Rafael Moreira <rafael.gmoreira@cidadania.gov.br>
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, jsr250Enabled = true, prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	/*
    @Bean
    protected JWTFilter tokenAuthenticationFilter() {
        return new JWTFilter(Constantes.SG_SISTEMA);
    }

    /**
     * configuracoes spring security
     *
     * caso queira todas as request autenticadas:
     * .and().authorizeRequests().anyRequest().authenticated()
     *
     * caso queira alguma request liberada:
     * .and().authorizeRequests().antMatchers("/url-path/**").permitAll()
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .cors()
            .and()
            .csrf()
            .disable()
            .authorizeRequests()
            .and()
            .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .formLogin()
                .disable()
                .httpBasic()
                .disable()
                .exceptionHandling()
                .and().authorizeRequests() 
                .antMatchers("/api/**").authenticated()
                ;

       // http.addFilterBefore(tokenAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
        	.antMatchers(HttpMethod.OPTIONS, "/**")
        	//.antMatchers(HttpMethod.POST, "/**")
        	//.antMatchers(HttpMethod.DELETE, "/**")
            .antMatchers("/login/**")
            .antMatchers("/actuator/**")
            .antMatchers("/swagger-ui/**")
            //.antMatchers("/api/publica/**")
            ;
    }

}
