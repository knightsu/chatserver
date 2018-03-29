package com.chat;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;


@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
@CrossOrigin(origins = {"http://localhost:8000", "null"})
public class BootStarter {

    public static void main(String[] args)
    {
        SpringApplication.run(BootStarter.class, "--debug");
    }
}
