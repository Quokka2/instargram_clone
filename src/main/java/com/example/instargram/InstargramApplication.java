package com.example.instargram;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManagerFactory;

@SpringBootApplication
public class InstargramApplication implements CommandLineRunner {

    @Autowired
    EntityManagerFactory emf;

    public static void main(String[] args) {
        SpringApplication.run(InstargramApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("emf = " + emf);
    }
}
