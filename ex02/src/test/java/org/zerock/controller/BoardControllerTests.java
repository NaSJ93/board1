package org.zerock.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.extern.log4j.Log4j;
@WebAppConfiguration //컨트롤러 테스트 위해 추가
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"	//컨트롤러 테스트 위해 추가	
})	//컨트롤러는 웹서버에서 돌아가므로 servlet에도 추가를 해야함
@Log4j
public class BoardControllerTests {	//214p
	
	@Autowired	//mock과 달리 자동 저장이 가능
	private WebApplicationContext ctx;	//mockMvc 객체를 만들때 필요
	
	private MockMvc mockMvc;	//이 객체를 이용해서 컨트롤러 테스트 가능함(굳이 서버를 열어서 하지 않고)
								//또한 객체를 직접 인스턴(생성)해서 사용해야함
	@Before	//junit꺼 골라야함 / junit으로 테스트 할때 먼저 수행하는 메소드	//mockMvc는 처음에 null값이라서
	public void setup() {
		mockMvc=MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	@Test
	public void testList() throws Exception {												
					//board/list?id=abc&pw=1234
		//MockMvcRequestBuilders.get("/board/list").param("id", "abc").param("pw", "1234");
																						//post면 post
		log.info("url리스트 요청 결과 모델 데이터 :"+
				mockMvc.perform(MockMvcRequestBuilders.get("/board/list")).
				andReturn().getModelAndView().getModelMap());
	}
///////이 위에 있는 것은 일일이 톰켓 같은 서버를 연결해서 확인하는 과정을 거치지 않고 하는것임
	
	@Test
	public void testRegister() throws Exception {				
		log.info("등록 처리 요청 결과 :"+
				mockMvc.perform(MockMvcRequestBuilders.post("/board/register").
						param("title", "junit으로").
						param("content", "mockMVC를 이용해서").
						param("writer", "tester1")).
				andReturn().getModelAndView().getViewName());
	}
	
	@Test
	public void testGet() throws Exception {	
		log.info("url 상세보기 요청 결과 데이터 :"+
				mockMvc.perform(MockMvcRequestBuilders.get("/board/get?bno=25")).
				andReturn().getModelAndView().getModelMap());
			//mockMvc.perform(MockMvcRequestBuilders.get("/board/get?bno=25").
			//		param("bno", "25")).
			//andReturn().getModelAndView().getModelMap());
			
	}
	
	@Test
	public void testRemove() throws Exception {				
		log.info("url 삭제 처리 요청 결과 :"+
				mockMvc.perform(MockMvcRequestBuilders.post("/board/remove").						
						param("bno", "25")).
				andReturn().getModelAndView().getViewName());
	}
	
	@Test
	public void testModify() throws Exception {				
		log.info("수정 처리 요청 결과 :"+
				mockMvc.perform(MockMvcRequestBuilders.post("/board/modify").
						param("bno", "26").
						param("title", "juns으로").
						param("content", "modg를 이용해서")).						
				andReturn().getModelAndView().getViewName());
	}
	
	@Test
	public void testGetRegister() throws Exception {
		log.info("url 등록화면 요청:"+
			mockMvc.perform(MockMvcRequestBuilders.get("/board/register"))
			.andReturn().getModelAndView().getViewName());
	}
	
	@Test
	public void testGetRemove() throws Exception {
		log.info("url 삭제화면 요청:"+
			mockMvc.perform(MockMvcRequestBuilders.get("/board/remove"))
			.andReturn().getModelAndView().getViewName());
	}
	
	
}
