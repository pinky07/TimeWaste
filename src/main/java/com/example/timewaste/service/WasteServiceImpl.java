package com.example.timewaste.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.timewaste.model.Waste;
import com.example.timewaste.repository.WasteRepository;



@Service("wasteService")
public class WasteServiceImpl implements WasteService {
	@Autowired 
	public WasteRepository wasteRepository;

	@Override
	public Waste saveWaste(Waste holiday) {
		// TODO Auto-generated method stub
		return  wasteRepository.save(holiday);
	}

	

	@Override
	public Waste findById(int id) {
		// TODO Auto-generated method stub
		return wasteRepository.findById(id);
	}

	@Override
	public List<Waste> findAll() {
		// TODO Auto-generated method stub
		return wasteRepository.findAll();
	}

	@Override
	public Long deleteById(int id) {
		// TODO Auto-generated method stub
		return wasteRepository.deleteById(id);
	}

}
