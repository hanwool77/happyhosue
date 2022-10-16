package com.ssafy.happyhouse.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.HouseDetailDto;
import com.ssafy.happyhouse.model.HouseInfoDto;
import com.ssafy.happyhouse.model.SearchDto;
import com.ssafy.happyhouse.model.SidoGugunDongCodeDto;
import com.ssafy.happyhouse.model.mapper.HouseMapMapper;

@Service
public class HouseMapServiceImpl implements HouseMapService {
	
	@Autowired
	private HouseMapMapper houseMapMapper;

	@Override
	public List<SidoGugunDongCodeDto> getSido() throws Exception {
		return houseMapMapper.getSido();
	}

	@Override
	public List<SidoGugunDongCodeDto> getGugunInSido(String sido) throws Exception {
		return houseMapMapper.getGugunInSido(sido);
	}

	@Override
	public List<HouseInfoDto> getDongInGugun(String gugun) throws Exception {
		return houseMapMapper.getDongInGugun(gugun);
	}

	@Override
	public List<HouseInfoDto> getAptInDong(SearchDto search) throws Exception {
		return houseMapMapper.getAptInDong(search);
	}

	@Override
	public List<HouseDetailDto> getAptDetail(long no) throws Exception {
		return houseMapMapper.getAptDetail(no);
	}
	
	@Override
	public List<HouseInfoDto> getAptPriceRange(String dong, int minPrice, int maxPrice) throws Exception {
		return houseMapMapper.getAptPriceRange(dong, minPrice, maxPrice);
	}

}
