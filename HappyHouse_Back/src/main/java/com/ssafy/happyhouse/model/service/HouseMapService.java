package com.ssafy.happyhouse.model.service;

import java.util.List;

import com.ssafy.happyhouse.model.HouseDetailDto;
import com.ssafy.happyhouse.model.HouseInfoDto;
import com.ssafy.happyhouse.model.SearchDto;
import com.ssafy.happyhouse.model.SidoGugunDongCodeDto;

public interface HouseMapService {

	List<SidoGugunDongCodeDto> getSido() throws Exception;
	List<SidoGugunDongCodeDto> getGugunInSido(String sido) throws Exception;
	List<HouseInfoDto> getDongInGugun(String gugun) throws Exception;
	List<HouseInfoDto> getAptInDong(SearchDto search) throws Exception;
	List<HouseDetailDto> getAptDetail(long no) throws Exception;
	List<HouseInfoDto> getAptPriceRange(String dong, int minPrice, int maxPrice) throws Exception;
}
