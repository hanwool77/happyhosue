package com.ssafy.happyhouse.model.mapper;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.model.HouseDetailDto;
import com.ssafy.happyhouse.model.HouseInfoDto;
import com.ssafy.happyhouse.model.SearchDto;
import com.ssafy.happyhouse.model.SidoGugunDongCodeDto;

public interface HouseMapMapper {

	List<SidoGugunDongCodeDto> getSido() throws SQLException;
	List<SidoGugunDongCodeDto> getGugunInSido(String sido) throws SQLException;
	List<HouseInfoDto> getDongInGugun(String gugun) throws SQLException;
	List<HouseInfoDto> getAptInDong(SearchDto search) throws SQLException;
	List<HouseDetailDto> getAptDetail(long no) throws SQLException;
	List<HouseInfoDto> getAptPriceRange(String dong, int minPrice, int maxPrice) throws SQLException;
}
