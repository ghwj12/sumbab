package com.sumbab.project.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class NoticeService {
	private NoticeDaoImpl memberDao;

	@Autowired
	public void setMemberDao(NoticeDaoImpl memberDao) {
		this.memberDao = memberDao;
	}
	
	public List<Notice> bringNotice(String id) {
		int classify = memberDao.selectCalssify(id);
		if(classify == 3) {
			return memberDao.allNotice();
		} else {
			return memberDao.selectNotice(id);
		}
	}

}
