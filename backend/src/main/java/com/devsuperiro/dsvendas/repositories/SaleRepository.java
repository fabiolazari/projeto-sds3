package com.devsuperiro.dsvendas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperiro.dsvendas.dto.SaleSuccessDTO;
import com.devsuperiro.dsvendas.dto.SaleSumDTO;
import com.devsuperiro.dsvendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long>{
	
	@Query("SELECT NEW com.devsuperiro.dsvendas.dto.SaleSumDTO(obj.seller, SUM(obj.amount)) "
			+ " FROM Sale obj GROUP BY obj.seller")
	List<SaleSumDTO> amountGroupedBySeller();
	
	
	@Query("SELECT NEW com.devsuperiro.dsvendas.dto.SaleSuccessDTO(obj.seller, SUM(obj.visited), SUM(obj.deals)) "
			+ " FROM Sale obj GROUP BY obj.seller")
	List<SaleSuccessDTO> successGroupedBySeller();
}
