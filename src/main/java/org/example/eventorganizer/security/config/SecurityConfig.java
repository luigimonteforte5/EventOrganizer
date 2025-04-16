package org.example.eventorganizer.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.client.oidc.web.logout.OidcClientInitiatedLogoutSuccessHandler;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
	private final ClientRegistrationRepository clientRegistrationRepository;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.oauth2Client(oauth2Client -> {
		}).oauth2Login(oauth2Login -> oauth2Login.tokenEndpoint(tokenEndpoint -> {
		}).userInfoEndpoint(userInfoEndpoint -> {
		}))
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
}
