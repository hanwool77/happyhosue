package com.ssafy.happyhouse.model.service;

import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.model.MemberDto;

public interface MemberService {
//	MemberDto login(Map<String, String> map) throws Exception;
//	
//	int idCheck(String checkId) throws Exception;
//	void registerMember(MemberDto memberDto) throws Exception;
//	
//	List<MemberDto> listMember() throws Exception;
//	MemberDto getMember(String userId) throws Exception;
//	void updateMember(MemberDto memberDto) throws Exception;
//	void deleteMember(String userId) throws Exception;
//	String getSalt(String userId) throws Exception;
	
	public MemberDto login(MemberDto memberDto) throws Exception;
	public MemberDto userInfo(String userid) throws Exception;
	public boolean signup(MemberDto memberDto) throws Exception;
	public boolean modify(MemberDto memberDto) throws Exception;
	public boolean secession(MemberDto member) throws Exception;
	
}
