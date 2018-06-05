package com.example.timewaste.service;

import java.util.List;

import javax.transaction.Transactional;
import com.example.timewaste.model.Waste;


public interface WasteService {
	public Waste saveWaste(Waste holiday);
	
	public Waste findById(int id);
	public List<Waste> findAll();
	@Transactional
    Long deleteById(int id);
}
