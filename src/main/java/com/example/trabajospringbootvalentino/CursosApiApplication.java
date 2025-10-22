package com.example.trabajospringbootvalentino;

import com.example.trabajospringbootvalentino.entity.*;
import com.example.trabajospringbootvalentino.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CursosApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(CursosApiApplication.class, args);
    }

}
