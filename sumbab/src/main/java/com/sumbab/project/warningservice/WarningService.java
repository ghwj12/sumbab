package com.sumbab.project.warningservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sumbab.project.warning.ChangeClassifyDto;
import com.sumbab.project.warning.MemberClassifyVo;
import com.sumbab.project.warning.WarningDaoImpl;
import com.sumbab.project.warning.WarningDto;
import com.sumbab.project.warning.WarningVo;

@Service
public class WarningService {
	
	@Autowired
	private WarningDaoImpl warningDao;

	public List<WarningVo> bringWarning(){
		return warningDao.allReport();
	}
	
	public WarningVo reportDetail(int warningNum) {
		return warningDao.reportDetail(warningNum);
	}
	
	public void changeClassify(ChangeClassifyDto classifyDto) {
		warningDao.changeClassify(classifyDto);
	}
	
	public void delete(int warningNum) {
		warningDao.delete(warningNum);
	}
	
	public void insert(WarningDto warningDto, int reviewNum, String id) {
		warningDto.setReviewNum(reviewNum);
		warningDto.setReporter(id);
		warningDao.insert(warningDto);
	}
	
	public List<MemberClassifyVo> selectMember() {
		return warningDao.selectMember();
	}
	
	public void returnClassify(String id) {
		warningDao.updateMemberClassify(id);
	}
}