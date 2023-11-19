package org.sid.customerservice;

import org.sid.customerservice.entities.Customer;
import org.sid.customerservice.repository.CustomerRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);

    }


    @Bean
    public CommandLineRunner commandLineRunner(CustomerRepo customerRepo){
        return args -> {
               customerRepo.saveAll(
                       List.of(
                               Customer.builder().nom("anas").email("anas@google.com")
                                       .build(),
                               Customer.builder().nom("bilal").email("anas@google.com")
                                       .build(),
                               Customer.builder().nom("atmane").email("anas@google.com")
                                       .build()
                       )

               );

               customerRepo.findAll().forEach(System.out::println);
        };
    }

}
