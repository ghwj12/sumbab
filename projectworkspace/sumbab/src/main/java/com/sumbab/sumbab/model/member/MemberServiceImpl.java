package com.sumbab.sumbab.model.member;

import javax.inject.Inject;

import org.springframework.stereotype.Service;


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
