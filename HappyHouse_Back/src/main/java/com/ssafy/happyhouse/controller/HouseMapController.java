package com.ssafy.happyhouse.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.model.HouseDetailDto;
import com.ssafy.happyhouse.model.HouseInfoDto;
import com.ssafy.happyhouse.model.SearchDto;
import com.ssafy.happyhouse.model.SidoGugunDongCodeDto;
import com.ssafy.happyhouse.model.service.HouseMapService;

@RestController
@RequestMapping("/map")
@CrossOrigin("*") 
public class HouseMapController {
	
	private final Logger logger = LoggerFactory.getLogger(HouseMapController.class);

	@Autowired
	private HouseMapService haHouseMapService;
	
	@GetMapping("/sido")
	public ResponseEntity<List<SidoGugunDongCodeDto>> sido() throws Exception {
		logger.debug("sido : {}", haHouseMapService.getSido());
		return new ResponseEntity<List<SidoGugunDongCodeDto>>(haHouseMapService.getSido(), HttpStatus.OK);
	}
	
	@GetMapping("/gugun")
	public ResponseEntity<List<SidoGugunDongCodeDto>> gugun(@RequestParam("sido") String sido) throws Exception {
		return new ResponseEntity<List<SidoGugunDongCodeDto>>(haHouseMapService.getGugunInSido(sido), HttpStatus.OK);
	} 
	
	@GetMapping("/dong")
	public ResponseEntity<List<HouseInfoDto>> dong(@RequestParam("gugun") String gugun) throws Exception {
		logger.debug(gugun);
		return new ResponseEntity<List<HouseInfoDto>>(haHouseMapService.getDongInGugun(gugun), HttpStatus.OK);
	}
	
	@GetMapping("/apt")
	public ResponseEntity<List<HouseInfoDto>> apt(SearchDto search) throws Exception {
		System.out.println(search);
		return new ResponseEntity<List<HouseInfoDto>>(haHouseMapService.getAptInDong(search), HttpStatus.OK);
	}
	
	@GetMapping("/apt/detail")
	public ResponseEntity<List<HouseDetailDto>> apt(@RequestParam("no") long no) throws Exception {
		List<HouseDetailDto> aptDetail = haHouseMapService.getAptDetail(no);
		for(HouseDetailDto h : aptDetail) {
			System.out.println(h);
		}
		return new ResponseEntity<List<HouseDetailDto>>(aptDetail, HttpStatus.OK);
	}
	
//	@GetMapping("/apt/priceRange")
//	public ResponseEntity<List<HouseInfoDto>> price(@RequestParam("dong") String dong, @RequestParam(value="minPrice", required=false) String minPrice, @RequestParam(value= "maxPrice") String maxPrice) throws Exception {
//		
//		if (maxPrice == "") {
//			maxPrice = "2147483647";
//		}
//
//		List<HouseInfoDto> priceRange = haHouseMapService.getAptInDong(dong);
//		
//		for (int i = 0; i < priceRange.size(); i++) {
//			
//			int aptRecentPrice = Integer.parseInt(priceRange.get(i).getRecentPrice().replaceAll(" ","").replaceAll(",", ""));
//			
//			if( (aptRecentPrice < Integer.parseInt(minPrice)) 
//					|| (aptRecentPrice > Integer.parseInt(maxPrice)) ) {
//				priceRange.remove(i);
//				i--;
//			}
//			
//		}
//		
//		return new ResponseEntity<List<HouseInfoDto>>(priceRange, HttpStatus.OK);
//	}
	
	
	
}
