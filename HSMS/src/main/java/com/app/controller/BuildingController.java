package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.BuildingDTO;
import com.app.dto.BuildingIdDTO;
import com.app.services.BuildingService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/buildings")
public class BuildingController {

	/*
	 * private final BuildingService buildingService;
	 * 
	 * @Autowired public BuildingController(BuildingService buildingService) {
	 * this.buildingService = buildingService; }
	 */

	@Autowired
	BuildingService buildingService;

	
	@PostMapping("/addBuilding")
	public ResponseEntity<?> addBuilding(@RequestBody BuildingDTO building) {

		try {
			BuildingDTO newBuildingDto = buildingService.addBuilding(building);
			if (newBuildingDto == null) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Only Admin can Add a Building!");
			}
			return ResponseEntity.status(HttpStatus.CREATED).body(building);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Some error Ocurred!"+e.getMessage());
		}
	}

	@GetMapping
	public ResponseEntity<?> getAllBuilding() {
		try {
			List<BuildingIdDTO> buildingIdDTOs = buildingService.getAllBuilding();
			return ResponseEntity.status(HttpStatus.OK).body(buildingIdDTOs);			
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Some error Occurred" + e.getMessage());
		}
	}

}
