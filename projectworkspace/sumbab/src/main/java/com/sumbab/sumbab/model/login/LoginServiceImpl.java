package com.sumbab.sumbab.model.login;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private MemberDao memberDao;
	
	
//	public MemberDao getMemberDao() {
//		return memberDao;
//	}
//
//	
//	public void setMemberDao(MemberDao memberDao) {
//		this.memberDao = memberDao;
//	}


	//회원가입
	@Override
	public void register(MemberVo vo) {
		memberDao.insert(vo);
		
		
	}
	
	//로그인 
	@Override
	public boolean login(MemberVo vo, HttpSession session) {
		
		boolean result = memberDao.select(vo);
		if(result) {
			MemberVo vo2 = login2(vo);
			session.setAttribute("vo", vo2);
//			session.setAttribute("id", vo2.getId());
//			session.setAttribute("pwd", vo2.getPwd());
			
			
		}
		return result;
		
		
		
	}
	@Override
	public MemberVo login2(MemberVo vo) {
		
		return memberDao.select2(vo);
	}
	
	@Override
	public MemberVo idFind(MemberVo vo) {
		
	
		return memberDao.idFind(vo);
	}
	
	@Override
	public MemberVo pwdFind(MemberVo vo) {
		
		return memberDao.pwdFind(vo);
	}
	@Override
	public void logout(HttpSession session) {
		session.removeAttribute("vo");
		
	}
	@Override
	public void kalogout(HttpSession session) {
//		session.removeAttribute("kemail");
//		session.removeAttribute("kname");
		session.removeAttribute("access_Token");
	}
	
	@Override
	public void kaLoginInsert(Map<String, Object> map) {
		
		memberDao.kaLoginInsert(map);
		
	}
	
	@Override
	public boolean kaLoginSelect(Map<String, Object> map) {
		
		 boolean kLS = memberDao.kaLoginSelect(map);
		 
	
		 
		
		return kLS;
	}
	@Override
	public MemberVo kaLoginSelect2(Map<String, Object> map,HttpSession session) {
		
		 MemberVo result = memberDao.kaLoginSelect2(map);
		 
		 
		 session.setAttribute("vo", result);
		 
	
		
		 return result;
	}
	
	//정민
	@Override
	public void memberDelete(MemberVo memberVO) {
		memberDao.memberDelete(memberVO);
		
	}
}
