package com.sumbab.project.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WarningService {
	
	@Autowired
	private WarningDaoImpl warningDao;

	public List<Warning> bringWarning(){
		return warningDao.selectWarning();
	}
}
