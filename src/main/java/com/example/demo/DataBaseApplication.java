package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DataBaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataBaseApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(Repository repository) {

        return (args) -> {
            repository.save(new ProfilesEntity(3,"Jack", "Bauer"));
            repository.save(new ProfilesEntity(4,"Nick", "Robertson"));


            // Show all profiles by method findAll()
            System.out.println(("Profile found with findAll():"));
            System.out.println(("-------------------------------"));
            for (ProfilesEntity profile : repository.findAll()) {
                System.out.println((profile.toString()));
            }

            //Show profile by method findById()
            System.out.println("Profile found with findById(4):");
            System.out.println("-------------------------------");
            System.out.println(repository.findById(4).toString());

            //Show profile by method findByLastName()
            System.out.println("Profile found by findByLastName('Bauer'):");
            System.out.println("-------------------------------");
            System.out.println(repository.findByLastName("Bauer"));

            //Show profile by method findByFirstName()
            System.out.println("Profile found by findByFirstName('Сергей'):");
            System.out.println("-------------------------------");
            System.out.println(repository.findByFirstName("Сергей"));
        };
    }
}
