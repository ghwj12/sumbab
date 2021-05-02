package store.search;

import java.util.List;

import store.Store;

public interface SearchDao {

	public List<Store> search(String input);
	
	//public List<Store> selectByKeyword(String keyword); //일반 검색
	//public List<Store> selectByTag(String tag);  //해시태그 검색
	
}
