package com.sumbab.project.model;

import java.util.List;

public interface RecommendDao {

	//???  μΉ΄νκ³ λ¦¬ μΆμ²
	public List<StoreVo> selectRest(String category);
	
	//μΉ΄ν μΉ΄νκ³ λ¦¬ μΆμ²(?? ?κ°λ³ ? ?Έ)
	public List<StoreVo> selectCafe1(String category);
	
	//μΉ΄ν μΉ΄νκ³ λ¦¬ μΆμ²(?? ?κ°λ³)
	public List<StoreVo> selectCafe2(String category);
}
