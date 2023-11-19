package org.sid.inventoryservice.repository;

import org.sid.inventoryservice.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepoitory extends JpaRepository<Produit,Long> {

}
