package admin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import de.codecentric.boot.admin.server.config.AdminServerProperties;

@Profile("secure")
@Configuration
public class SecuritySecureConfig extends WebSecurityConfigurerAdapter {
	private final String adminContextPath;

	public SecuritySecureConfig(AdminServerProperties adminServerProperties) {
		this.adminContextPath = adminServerProperties.getContextPath();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// @formatter:off
        SavedRequestAwareAuthenticationSuccessHandler successHandler = new SavedRequestAwareAuthenticationSuccessHandler();
        successHandler.setTargetUrlParameter("redirectTo");
        successHandler.setDefaultTargetUrl(this.adminContextPath + "/");

        http.authorizeRequests()
            .antMatchers(this.adminContextPath + "/assets/**").permitAll()
            .antMatchers(this.adminContextPath + "/login").permitAll()
            .anyRequest().authenticated()
            .and()
        .formLogin().loginPage(this.adminContextPath + "/login").successHandler(successHandler).and()
        .logout().logoutUrl(this.adminContextPath + "/logout").and()
        .httpBasic().and()
        .csrf()
            .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
            .ignoringAntMatchers(
                this.adminContextPath + "/instances",
                this.adminContextPath + "/actuator/**"
            );
        // @formatter:on
	}
}