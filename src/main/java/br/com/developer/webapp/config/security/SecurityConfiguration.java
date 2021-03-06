package br.com.developer.webapp.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final AutenticacaoService autenticacaoService;

    @Autowired
    public SecurityConfiguration(AutenticacaoService autenticacaoService) {
        this.autenticacaoService = autenticacaoService;
    }


    //Configura ações de autenticações
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(autenticacaoService).passwordEncoder(new BCryptPasswordEncoder());

    }
    //Configurações de autorização
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers(HttpMethod.GET,"/topicos")
                .permitAll()
            .antMatchers(HttpMethod.GET,"/topicos/*").permitAll()
            .anyRequest().authenticated()
            .and().formLogin();

    }

    //COnfigurações de recursos estáticos(JavaScript, Css, Imagens
    @Override
    public void configure(WebSecurity web) throws Exception {

    }
}
