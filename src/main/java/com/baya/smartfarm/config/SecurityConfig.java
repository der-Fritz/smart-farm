package com.baya.smartfarm.config;//package com.cbsolutions.smartfarmer.config;
//
//import com.cbsolutions.smartfarmer.security.JWTConfigurer;
//import com.cbsolutions.smartfarmer.security.JwtAuthenticationFilter;
//import com.cbsolutions.smartfarmer.security.JwtTokenProvider;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.ldap.core.LdapTemplate;
//import org.springframework.ldap.core.support.BaseLdapPathContextSource;
//import org.springframework.ldap.core.support.LdapContextSource;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.config.BeanIds;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.ldap.DefaultSpringSecurityContextSource;
//import org.springframework.security.ldap.authentication.BindAuthenticator;
//import org.springframework.security.ldap.authentication.LdapAuthenticationProvider;
//import org.springframework.security.ldap.search.FilterBasedLdapUserSearch;
//import org.springframework.security.ldap.search.LdapUserSearch;
//
//
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(jsr250Enabled = true)
//@RequiredArgsConstructor
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Value("${bureau.de.change.ldap.url}")
//    private String ldapUrl;
//    @Value("${bureau.de.change.ldap.manager.password}")
//    private String ldapPassword;
//    @Value("${bureau.de.change.ldap.basedn}")
//    private String baseDn;
//    @Value("${bureau.de.change.ldap.manager.user}")
//    private String managerUser;
//    @Value("${bureau.de.change.ldap.searchFilter.login}")
//    private String searchFilter;
//    @Value("${bureau.de.change.ldap.UserDnPattern}")
//    private String ldapUserDnPattern;
//
//    private final JwtTokenProvider jwtTokenProvider;
//
//    private final JwtAuthenticationFilter jwtAuthenticationFilter;
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .csrf()
//                .disable()
//                .cors()
//                .disable()
//                .exceptionHandling()
//                .and()
//                .sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
//                .authorizeRequests()
//                .antMatchers(HttpMethod.OPTIONS).permitAll()
//                .antMatchers(
//                        "/login/**",
//                        "/location/**",
//                        "/tsp/register/**",
//                        "/subscriber/points/**",
//                        "/implement/**",
//                        "/tsp/find/**",
//                        "/reward/eligible/**",
//                        "/points/redeem/**"
//                ).permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .apply(securityConfigurerAdapter());
//    }
//
//    private JWTConfigurer securityConfigurerAdapter() {
//        return new JWTConfigurer(jwtTokenProvider, jwtAuthenticationFilter);
//    }
//
//    @Bean(BeanIds.AUTHENTICATION_MANAGER)
//    @Override
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }
//
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth, AuthenticationProvider authenticationProvider) {
//        auth.authenticationProvider(authenticationProvider);
//    }
//
//    @Bean
//    public BaseLdapPathContextSource contextSource() {
//        final DefaultSpringSecurityContextSource source = new DefaultSpringSecurityContextSource(ldapUrl);
//        source.setUserDn(managerUser);
//        source.setPassword(ldapPassword);
//        return source;
//    }
//
//    @Bean
//    public LdapUserSearch ldapUserSearch() {
//        final FilterBasedLdapUserSearch userSearch = new FilterBasedLdapUserSearch(baseDn, searchFilter, contextSource());
//        userSearch.setSearchSubtree(true);
//        return userSearch;
//    }
//
//    @Bean
//    public LdapAuthenticationProvider authenticationProvider(BaseLdapPathContextSource contextSource,
//                                                             LdapUserSearch ldapUserSearch) {
//
//        final BindAuthenticator bindAuthenticator = new BindAuthenticator(contextSource);
//        bindAuthenticator.setUserSearch(ldapUserSearch);
//
//        return new LdapAuthenticationProvider(bindAuthenticator);
//    }
//
//
//    @Bean
//    public LdapContextSource ldapContextSource() {
//        final LdapContextSource source = new LdapContextSource();
//        source.setUrl(ldapUrl);
//        source.setBase(baseDn);
//        source.setUserDn(managerUser);
//        source.setPassword(ldapPassword);
//        return source;
//    }
//
//    @Bean
//    public LdapTemplate internalLdapTemplate(LdapContextSource ldapContextSource) {
//
//        return new LdapTemplate(ldapContextSource);
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//}