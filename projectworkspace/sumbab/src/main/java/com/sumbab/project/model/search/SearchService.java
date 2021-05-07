package com.sumbab.project.model.search;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sumbab.project.model.store.StoreVo;

@Service
public class SearchService {

	public SearchService() {}
	
	private SearchDaoImpl searchDao;
	
	@Autowired
	public SearchService(SearchDaoImpl searchDao) {
		this.searchDao = searchDao;
	}
	
	public List<StoreVo> selectByKeyword(String input) {
		return searchDao.selectByKeyword(input);
	}
	
	public List<StoreVo> selectByTag(String inputT){
		return searchDao.selectByTag(inputT);
	}
}
