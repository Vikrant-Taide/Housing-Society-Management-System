package com.app.services;

import java.util.List;

import com.app.dto.FlatDTO;
import com.app.dto.FlatIdDTO;

public interface FlatService {
	FlatDTO addFlat(FlatDTO flatdto);
	List<FlatIdDTO> getAllFlats();
	FlatIdDTO getSingleFlats(Long id);
	FlatDTO bookFlat(Long id);
	List<FlatIdDTO> getBuildingflats(long bid);

}
