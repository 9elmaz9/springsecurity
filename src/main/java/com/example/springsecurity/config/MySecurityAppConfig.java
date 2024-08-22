package com.example.springsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
//Настройка цепочки фильтров Spring Security
@EnableWebSecurity
public class MySecurityAppConfig   {

//public class MySecurityAppConfig extends WebSecurityConfigurerAdapter {  // old version secirity with WebSecurityConfigurerAdapter / the  one on top is better one

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {  // Этот метод определяет правила авторизации и добавляет форму логина.
        http.
                authorizeHttpRequests(authorize  ->authorize
        .requestMatchers("/gfg").authenticated() // Требует аутентификации для доступа к /gfg
                )
                .formLogin(); // Включаем форму для логина по умолчанию
        return http.build();
    }
/**Вместо использования AuthenticationManagerBuilder теперь создан UserDetailsService,
 *  который предоставляет встроенного пользователя gfg с ролью admin. Этот пользователь сохраняется в памяти.*/
    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        UserDetails user = User.builder()
                .username("elmaz")
                .password(passwordEncoder.encode("gfg123"))
                .roles("admin")
                .build();

        return new InMemoryUserDetailsManager(user);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // для хеширования паролей.
    }


}
















//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    /**
//     * Метод configure(AuthenticationManagerBuilder auth)  используется для настройки аутентификации пользователей.
//     * В этом методе вы добавляете пользователя gfg с паролем gfg123, который закодирован с использованием BCrypt.
//     */
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//
//
//        auth.inMemoryAuthentication()
//                .withUser("gfg")
//                .password("$2a$10$F5rzmMmNJcgwqTXmcro1eOeATecEUDsPM8WjKtF8Qx46RFDjlmCSW") // пароль "gfg123"
//                .roles("admin");
//    }
//
//
//    /**
//     * Метод configure(HttpSecurity http) — используется для настройки авторизации и других аспектов безопасности HTTP.
//     * Здесь вы указываете, что доступ к маршруту /gfg требует аутентификации. Если пользователь не аутентифицирован,
//     * он будет перенаправлен на страницу входа в систему.
//     */
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//        http.authorizeRequests()
//                .antMatchers("/gfg").authenticated() // Требует аутентификации для доступа к /gfg
//                .and()
//                .formLogin(); // Включаем форму для логина по умолчанию
//    }
//
//
//}
//
//
////Этот метод (configure(HttpSecurity http)) необходим для корректной работы Spring Security,
// так как он определяет, как будет происходить аутентификация и авторизация в вашем приложении