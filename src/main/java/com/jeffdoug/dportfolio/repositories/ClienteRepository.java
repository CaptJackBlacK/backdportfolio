package com.jeffdoug.dportfolio.repositories;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jeffdoug.dportfolio.domain.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	@Query(value = "SELECT count(id) FROM CLIENTE WHERE DATA BETWEEN ?1 AND ?2", nativeQuery = true)
	
	String findByData(Date data1, Date data2);	
	
	
}