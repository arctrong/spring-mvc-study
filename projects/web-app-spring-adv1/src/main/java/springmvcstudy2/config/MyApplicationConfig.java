package springmvcstudy2.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "springmvcstudy2.controllers")
public class MyApplicationConfig {
}
