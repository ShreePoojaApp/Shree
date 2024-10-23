package com.shreepooja.utils;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;

@Configuration
public class MessageSourceConfig {

    private final Locale locale = LocaleContextHolder.getLocale();

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    /**
     * This is a method that takes the param to substitute the placeholder
     **/
    public String getString(final String key, Object... params) {
        try {
            System.out.println("Locale: " + locale.getCountry());
            return MessageFormat.format(this.messageSource().getMessage(key, null, locale), params);
        } catch (MissingResourceException e) {
            return "[" + key + "]";
        }
    }

    /**
     * Without a param, this will directly delegate to ResourceBundle#getString
     **/
    public String getString(final String key) {
        try {
            return this.messageSource().getMessage(key, null, locale);
        } catch (MissingResourceException e) {
            return "[" + key + "]";
        }
    }
}