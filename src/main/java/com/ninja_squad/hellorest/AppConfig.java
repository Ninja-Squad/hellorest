package com.ninja_squad.hellorest;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.ninja_squad.hellorest.controller", "com.ninja_squad.hellorest.config"})
public class AppConfig {

}
