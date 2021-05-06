package org.garnet.exam;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class HomeControllerTest {
        private static final Logger logger = LoggerFactory.getLogger(HomeControllerTest.class);
        
        @Inject
        private WebApplicationContext wac;
        private MockMvc mockMvc;
    	//MockMvc는 브라우저에서 요청과 응답을 의미하는 객체. 가상의 요청과 응답을 처리하는 역할을 한다.

        
        @Before //매 실행 전에 MockMvc객체를 생성
        public void setup() {
                this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
                logger.info("setup...........");
        }
        
        @Test
        public void testIndex() throws Exception{
                mockMvc.perform(MockMvcRequestBuilders.get("/"));
        }

}
