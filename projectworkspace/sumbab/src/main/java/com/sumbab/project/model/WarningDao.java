package com.sumbab.project.model;

import java.util.List;

public interface WarningDao {

	public List<Warning> allReport();
	
	public WarningVo reportDetail(int warningNum);
}
