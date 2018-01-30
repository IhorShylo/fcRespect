package com.shylo.fcrespect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class FcrespectApplication {

    public static void main( String[] args ) {
        SpringApplication.run( FcrespectApplication.class, args );
    }
}
