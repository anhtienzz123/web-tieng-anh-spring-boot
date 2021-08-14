package webtienganh.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import webtienganh.service.UserService;
import webtienganh.service.impl.CustomOAuth2User;
import webtienganh.service.impl.CustomOAuth2UserService;
import webtienganh.utils.JwtAuthenticationFilter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private CustomOAuth2UserService customOAuth2UserService;
	
	@Autowired
	private UserService userService;

	@Bean
	public JwtAuthenticationFilter jwtAuthenticationFilter() {
		return new JwtAuthenticationFilter();
	}

	@Bean(BeanIds.AUTHENTICATION_MANAGER)
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {

		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.cors().and().csrf().disable().authorizeRequests().antMatchers("/admin/exams", "/admin/exams/**")
				.hasAnyRole("EXAM", "ADMIN").antMatchers("/admin/videos", "/admin/videos/**")
				.hasAnyRole("VIDEO", "ADMIN").antMatchers("/admin/blogs", "/admin/blogs/**").hasAnyRole("BLOG", "ADMIN")
				.antMatchers("/admin/courses", "/admin/courses/**").hasAnyRole("COURSE", "ADMIN")
				.antMatchers("/admin/**").hasRole("ADMIN").antMatchers("/user/**").authenticated().anyRequest()
				.permitAll().and().oauth2Login().loginPage("/login").userInfoEndpoint()
				.userService(customOAuth2UserService).and().successHandler(new AuthenticationSuccessHandler() {

					@Override
					public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
							Authentication authentication) throws IOException, ServletException {
						System.out.println("AuthenticationSuccessHandler invoked");
						System.out.println("Authentication name: " + authentication.getName());
						CustomOAuth2User oauthUser = (CustomOAuth2User) authentication.getPrincipal();

						userService.processOAuthPostLogin(oauthUser.getEmail());

						response.sendRedirect("/list");
					}
				});

		// Thêm một lớp Filter kiểm tra jwt
		http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);

	}
}
