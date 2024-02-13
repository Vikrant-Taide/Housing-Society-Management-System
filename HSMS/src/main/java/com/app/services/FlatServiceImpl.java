package com.app.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.BuildingRepository;
import com.app.dao.FlatRepository;
import com.app.dao.UserRepository;
import com.app.dto.FlatDTO;
import com.app.pojos.Flat;

@Service
@Transactional
public class FlatServiceImpl implements FlatService {
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private FlatRepository flatRepository;
	
	@Autowired
	private BuildingRepository buildingRepository;
	
	@Autowired
	private UserRepository userRepository;

	public FlatDTO addFlat(FlatDTO flatdto) {
	Flat flat=modelMapper.map(flatdto, Flat.class);
	flat.setBuilding(buildingRepository.findById(flatdto.getBuildingId()).get());
	flat.setUser(userRepository.findById(flatdto.getUserId()).get());
	System.out.println("Flat Building:"+flat.getBuilding());
	System.out.println("Flat OWner:"+flat.getUser());
	flatRepository.save(flat);
	return flatdto;
	
	}
	

}