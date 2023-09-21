package org.zerock.persistence;

import static org.junit.Assert.fail;

import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class JDBCTest {
	
	@Test
	public void testConnection()  {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "book_ex", "book_ex");
				log.info("접속성공");				
			} catch (Exception e) {
				log.info("접속실패");				
			//	e.printStackTrace();				
				fail(e.getMessage());	//테스트 실패
			}
	}	
	
}
