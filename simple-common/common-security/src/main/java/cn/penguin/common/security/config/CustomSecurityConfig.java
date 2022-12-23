package cn.penguin.common.security.config;

import cn.penguin.common.security.filter.CustomSecurityFilter;
import cn.penguin.common.security.handler.CustomAccessDeniedHandler;
import cn.penguin.common.security.handler.CustomLoginFailedHandler;
import cn.penguin.common.security.handler.CustomLogoutSuccessHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.Resource;

/**
 * @author wensy
 * @since 2022/12/1 10:31
 */
@Configuration
@EnableWebSecurity
public class CustomSecurityConfig {

    @Resource
    private AuthenticationConfiguration authenticationConfiguration;
    @Resource
    private CustomAccessDeniedHandler customAccessDeniedHandler;
    @Resource
    private CustomLoginFailedHandler customLoginFailedHandler;
    @Resource
    private CustomLogoutSuccessHandler customLogoutSuccessHandler;
    @Resource
    private CustomSecurityFilter customSecurityFilter;

    @Value("${project.security.ignoring-path:/doLogin,/}")
    private String[] ignoringPath;

    @Bean
    WebSecurityCustomizer webSecurityCustomizer(){
        return (web) -> {
            web.ignoring().antMatchers(this.ignoringPath);
        };
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.cors().and()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                // 要想启用customAccessDeniedHandler 得同时
                .exceptionHandling().authenticationEntryPoint(customLoginFailedHandler)
                .accessDeniedHandler(customAccessDeniedHandler).and()
                .authorizeRequests().anyRequest().authenticated().and()
                .headers().frameOptions().disable().and()
                .logout().logoutSuccessHandler(customLogoutSuccessHandler);
        http.addFilterBefore(customSecurityFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
