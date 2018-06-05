package com.example.timewaste.repository;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.timewaste.model.Waste;

@Repository("wasteRepository")
public interface WasteRepository extends JpaRepository<Waste,Long>{
	
	public Waste findById(int id);
	public List<Waste> findAll();
//	public void save(Holiday holiday);
	@Transactional
    Long deleteById(int id);
}
