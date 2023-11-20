package org.sid.inventoryservice;

import org.sid.inventoryservice.entities.Produit;
import org.sid.inventoryservice.repository.ProductRepoitory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.List;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }



    @Bean
    public CommandLineRunner commandLineRunner(ProductRepoitory productRepoitory,
                                               RepositoryRestConfiguration repositoryRestConfiguration){
        return args -> {
            repositoryRestConfiguration.exposeIdsFor(Produit.class);

              productRepoitory.saveAll(
                      List.of(


                               Produit.builder().nom("computer").price(18000)
                                      .build(),
                              Produit.builder().nom("mac book pro").price(18000)
                                      .build(),
                              Produit.builder().nom("imprimante").price(18000)
                                      .build(),
                              Produit.builder().nom("smarthphone").price(18000)
                                      .build()
                      )
              );

              productRepoitory.findAll().forEach(System.out::println);
        };
    }
}
