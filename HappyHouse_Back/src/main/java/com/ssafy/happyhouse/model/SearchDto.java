package com.ssafy.happyhouse.model;

public class SearchDto {
	String dong;
	Integer year;
	Integer minPrice;
	Integer maxPrice;

	public String getDong() {
		return dong;
	}

	public void setDong(String dong) {
		this.dong = dong;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(Integer minPrice) {
		this.minPrice = minPrice;
	}

	public Integer getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(Integer maxPrice) {
		this.maxPrice = maxPrice;
	}

	@Override
	public String toString() {
		return "SearchDto [dong=" + dong + ", year=" + year + ", minPrice=" + minPrice + ", maxPrice=" + maxPrice + "]";
	}

}
