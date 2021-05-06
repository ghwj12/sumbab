package com.sumbab.project.model;

import java.util.List;

public interface RecommendDao {

	//?Œ?‹?  ì¹´í…Œê³ ë¦¬ ì¶”ì²œ
	public List<StoreVo> selectRest(String category);
	
	//ì¹´í˜ ì¹´í…Œê³ ë¦¬ ì¶”ì²œ(?˜?—… ?‹œê°„ë³„ ? œ?™¸)
	public List<StoreVo> selectCafe1(String category);
	
	//ì¹´í˜ ì¹´í…Œê³ ë¦¬ ì¶”ì²œ(?˜?—… ?‹œê°„ë³„)
	public List<StoreVo> selectCafe2(String category);
}
