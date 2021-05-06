package com.sumbab.project.model;

import java.util.List;

public interface NoticeDao {
	
	//?–´?–¤ ?šŒ?›?¸ì§? ?•Œê¸? ?œ„?•´ ?šŒ?› êµ¬ë¶„ ë²ˆí˜¸ ê°?? ¸?˜¤ê¸?
	public int selectClassify(String id);
	
	//?•´?‹¹?•˜?Š” ?•„?´?””?˜ ê³µì?ê¸? ë¶ˆëŸ¬?˜¤ê¸?
	public List<Notice> selectNotice(String id);
	
	//?‚¬?´?Š¸ ?š´?˜??¼ ê²½ìš° ëª¨ë“  ê³µì?ê¸? ë¶ˆëŸ¬?˜¤ê¸?
	public List<Notice> allNotice();
	
	//ê³µì? ?ƒ?„¸ë³´ê¸°
	public Notice noticeDetail(int noticeNum);
	
	//ê³µì? ?˜¬ë¦¬ê¸°
	public void insert(Notice notice);
	
	//?‹ ê³? ?‚´?—­?—?„œ ë¦¬ë·° ë²ˆí˜¸ ë°›ì•„?„œ ê³µì? ?˜¬ë¦¬ê¸°
	public void fromWarning(Notice notice);
	
	//ê³µì? ?ˆ˜? •
	public void update(Notice notice);
	
	//ê³µì? ?‚­? œ
	public void delete(int noticeNum);
	
	//?•´?‹¹ ë¦¬ë·° ê°?? ¸?˜¤ê¸?
	public ReviewVo selectReview(int reviewNum);

}
