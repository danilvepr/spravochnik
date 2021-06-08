package ru.vsu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.sql.SQLException;

@Configuration
@ComponentScan("ru.vsu")
@PropertySource("classpath:bd.properties")
public class SpravochnicConfig {

}
