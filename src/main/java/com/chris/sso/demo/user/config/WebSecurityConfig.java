package com.chris.sso.demo.user.config;

import com.chris.sso.demo.user.handler.MyAuthenticationFailureHandler;
import com.chris.sso.demo.user.handler.MyAuthenticationSuccessHandler;
import com.chris.sso.demo.user.server.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserDetailsService userDetailsService;
    @Autowired
    private PersistentTokenRepository
            persistentTokenRepository;
    @Autowired
    private DataSource dataSource;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/assets/**", "/css/**", "/images/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.formLogin()
//                .loginPage("/login.html")
//                .loginProcessingUrl("/login")
//                .successHandler(new MyAuthenticationSuccessHandler("hello"))
//                .failureHandler(new MyAuthenticationFailureHandler("error.html"));
////                .failureForwardUrl("/toError")
////                .successForwardUrl("/loginn");
//        http.logout()
//                .logoutUrl("/logout")
//                .logoutSuccessUrl("/login.html");
//        http.rememberMe()
//                //设置数据源
//                .tokenRepository(persistentTokenRepository)
//                .tokenValiditySeconds(60)
//                .userDetailsService(userDetailsService);
        http.authorizeRequests()
//                .mvcMatchers("/login.html").servletPath("/author2").permitAll()
//                .mvcMatchers("/error.html").servletPath("/author2").permitAll()

                .antMatchers("/login.html", "/oauth/**", "/login/**", "/logout/**").permitAll()
                .antMatchers("/error.html").permitAll()
                .anyRequest()
                .authenticated()
//                .and()
//                .requestMatchers()
//                .antMatchers("/login.html","/oauth/**","/login/**","/logout/**");
                .and()
                .formLogin()
                .permitAll()
                .and()
                .csrf().disable();
    }

//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public PersistentTokenRepository persistentTokenRepository() {
//        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
//        jdbcTokenRepository.setDataSource(dataSource);
////        第一启动开启，第二次关闭
////        jdbcTokenRepository.setCreateTableOnStartup(true);
//        return jdbcTokenRepository;
//    }

}
