package com.microserviceslearning.inventoryservice.repository;

import java.util.Optional;

import com.microserviceslearning.inventoryservice.model.Inventory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface InventoryRepository extends JpaRepository<Inventory, Long>{

	
	@Query("SELECT inventory.skuCode FROM Inventory inventory ")
	Optional<Inventory> findBySkuCode();

}
