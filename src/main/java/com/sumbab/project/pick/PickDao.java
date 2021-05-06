package com.sumbab.project.pick;

	import java.util.List;

	public interface PickDao {
		
		//보관함에  있는 가게번호 가져오기
		public List<Integer> bringPick(String id);
		
		//보관함에 가게번호 추가
		public void addPick(PickVo pick);

	}


