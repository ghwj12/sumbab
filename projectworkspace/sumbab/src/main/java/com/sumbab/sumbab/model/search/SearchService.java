package com.sumbab.sumbab.model.search;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sumbab.sumbab.model.store.Store;

@Service
public class SearchService {

	public SearchService() {}
	
	private SearchDaoImpl searchDao;
	
	@Autowired
	public SearchService(SearchDaoImpl searchDao) {
		this.searchDao = searchDao;
	}
	
	public List<Store> selectByKeyword(String input) {
		return searchDao.selectByKeyword(input);
	}
	
	public List<Store> selectByTag(String inputT){
		return searchDao.selectByTag(inputT);
	}
}
