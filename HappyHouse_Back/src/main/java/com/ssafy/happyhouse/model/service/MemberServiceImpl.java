package com.ssafy.happyhouse.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.MemberDto;
import com.ssafy.happyhouse.model.mapper.MemberMapper;
import com.ssafy.happyhouse.model.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberMapper memberMapper;
	
	@Override
	public MemberDto login(MemberDto memberDto) throws Exception {
		if(memberDto.getUserid() == null || memberDto.getUserpwd() == null)
			return null;
		return memberMapper.login(memberDto);
	}

	@Override
	public MemberDto userInfo(String userid) throws Exception {
		return memberMapper.userInfo(userid);
	}
	
	@Override
	public boolean signup(MemberDto memberDto) throws Exception {
		return memberMapper.signup(memberDto) == 1;
	}
	
	@Override
	public boolean modify(MemberDto memberDto) throws Exception {
		return memberMapper.modify(memberDto) == 1;
	}
	
	@Override
	public boolean secession(MemberDto memberDto) throws Exception {
		return memberMapper.secession(memberDto) == 1;
	}

}
