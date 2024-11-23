package br.com.devchampions.hotlink.security.listeners;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;

import java.text.MessageFormat;

@Slf4j
@Configuration
public class AuthtenticationListeners {


    @Bean
    ApplicationListener<AuthenticationSuccessEvent> successEvent() {
        return event -> {
            log.info(MessageFormat.format("Login success: {0}", event.getAuthentication().getName()));
        };
    }

    @Bean
    ApplicationListener<AuthenticationFailureBadCredentialsEvent> failureEvent() {
        return event -> {
            log.info(MessageFormat.format("Login error: {0}", event.getAuthentication().getName()));
        };
    }

}
