package store;

import java.util.List;

public interface StoreDao {

	public void insert(Store store);
	public void update(Store store);
	public void delete(Store store);
	
	public List<Store> selectByRestCat(String category);
	public List<Store> selectByCafeCat(String category);
	//public List<Store> selectNearby(Store store); //현재위치값 들어있는 cords
	//public List<Store> selectByEditor(int editorNum); //editor table의 가게목록 seq 받아올 것
	
}
