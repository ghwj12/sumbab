package store;

import java.util.List;

import store.restCat.RestCat;

public interface StoreDao {

	public void insert(Store store);
	public void update(Store store);
	
	public List<Store> selectByKeyword(String keyword); //일반 검색
	public List<Store> selectByTag(String tag);  //해시태그 검색
	public List<Store> selectNearby(Store store); //현재위치값 들어있는 cords
	public List<Store> selectByRestCat(RestCat restCat); //카테고리 검색 class 만든 다음에 활성화
	//public List<Store> selectByCafeCat(Store store);
	public List<Store> selectByEditor(int editorNum); //editor table의 가게목록 seq 받아올 것
	
	public void delete(Store store);
}
