package login;

import java.util.Map;

import javax.servlet.http.HttpSession;



public interface MemberService {
	
	//회원 가입 프로세스여야한다 .....
	public void register(MemberVo vo);

	public boolean login(MemberVo vo, HttpSession session);
	
	public MemberVo login2(MemberVo vo);

	public MemberVo idFind(MemberVo vo);

	public MemberVo pwdFind(MemberVo vo);

	public void logout(HttpSession session);

	public void kalogout(HttpSession session);
	
	public void kaLoginInsert(Map<String, Object> map);
	
	public boolean kaLoginSelect(Map<String, Object> map);

	public MemberVo kaLoginSelect2(Map<String, Object> map,HttpSession session);
	
	
}
