package org.example.eventorganizer.security.config;

import org.example.eventorganizer.user.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.oauth2.client.oidc.web.logout.OidcClientInitiatedLogoutSuccessHandler;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
	private final ClientRegistrationRepository clientRegistrationRepository;
	private final UserService userService;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.oauth2Client(oauth2Client -> {
		})
				.oauth2Login(oauth2 -> oauth2.userInfoEndpoint(info -> info.oidcUserService(oidcUserService())))
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.ALWAYS))
				.authorizeHttpRequests(authorize -> authorize
						.requestMatchers("/unauthenticated", "/oauth2/**", "/login/**")
						.permitAll()
						.anyRequest()
						.fullyAuthenticated())
				.logout(logout -> logout.logoutSuccessHandler(oidcLogoutSuccessHandler()));

		return http.build();
	}

	@Bean
	public LogoutSuccessHandler oidcLogoutSuccessHandler() {
		OidcClientInitiatedLogoutSuccessHandler handler = new OidcClientInitiatedLogoutSuccessHandler(
				clientRegistrationRepository);
		handler.setPostLogoutRedirectUri("http://localhost:8081/");
		return handler;
	}

	@Bean
	public OAuth2UserService<OidcUserRequest, OidcUser> oidcUserService() {
		OidcUserService delegate = new OidcUserService();

		return (OidcUserRequest userRequest) -> {
			OidcUser oidcUser = delegate.loadUser(userRequest);
			userService.createOrUpdateFromOidc(oidcUser);
			return oidcUser;
		};
	}
}
