package org.garnet.exam;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/root-context.xml" })
public class MybatisTest {

	@Inject
	private SqlSessionFactory sqlSessionFactory;

	@Test
	public void testSqlSessionFactory() throws Exception {
		System.out.println(sqlSessionFactory);
	}

	@Test
	public void testSession() throws Exception {
		try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
			System.out.println(sqlSession);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
