package my.reserve;

import java.sql.Date;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReserveDaoImpl implements ReserveDao {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Autowired
	public ReserveDaoImpl(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	//예약내역 리스트 가져오기
	@Override
	public List<Reserve> list(String memberId) {
		List<Reserve> results = sqlSessionTemplate.selectList("listReserve", memberId);
return results;
	}

	//예약내역 삭제하기(취소하기) 현재 시간 기준으로 취소 가능 여부 결정
	@Override
	public void delete(Date sysdate) {
		sqlSessionTemplate.delete("deleteReserve", sysdate);
	}

	@Override
	public void insert(Reserve reserve) {
		sqlSessionTemplate.insert("insertReserve", reserve);
	}

}
