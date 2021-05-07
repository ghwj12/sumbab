package com.sumbab.member.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.sumbab.member.dao.MemberDao;
import com.sumbab.member.domain.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {

	@Inject
	private MemberDao memberDao;
	
	@Override
	public void memberJoinProcess(MemberVO memberVO) {
		memberDao.memberJoinMethod(memberVO);
	}
	
	@Override
	public int idCheck(String id) {
		int result = memberDao.idCheck(id);
		
		return result;
	}
	
}
