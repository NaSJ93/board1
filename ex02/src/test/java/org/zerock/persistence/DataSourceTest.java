package org.zerock.persistence;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")	
@Log4j
public class DataSourceTest {	//87p
	
	@Autowired
	private DataSource dataSource;
	
	@Test
	public void testConnection() throws SQLException {
		Connection conn= dataSource.getConnection();
		//Connection conn=는 없어도 테스트 됨, 원리가 이런거임
	}
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	@Test
	public void testMyBatis() {
		SqlSession session= sqlSessionFactory.openSession();
		session.getConnection();
	}
}
