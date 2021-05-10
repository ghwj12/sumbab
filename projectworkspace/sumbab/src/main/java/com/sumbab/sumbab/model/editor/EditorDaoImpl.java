package com.sumbab.sumbab.model.editor;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sumbab.sumbab.model.store.Store;

@Repository
public class EditorDaoImpl implements EditorDao {

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	@Autowired
	public EditorDaoImpl(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	@Override
	public void createList(Editor editor) {
		sqlSessionTemplate.selectOne("createList", editor);
	}

	@Override
	public List<Store> getAllStore() {
		return sqlSessionTemplate.selectList("getAllStore");
	}

}
