package com.sumbab.project.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecommendService {
	@Autowired
	private RecommendDaoImpl RecommendDao;
	
	
}
