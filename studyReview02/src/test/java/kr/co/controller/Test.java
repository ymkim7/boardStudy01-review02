package kr.co.controller;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class Test {
	
	private static final Logger logger = LoggerFactory.getLogger(Test.class);
	
	@Autowired
	private DataSource ds;
	
	@Autowired
	private SqlSessionFactory sql;
	
	@org.junit.Test
	@Ignore
	public void factoryTest() {
		logger.info("sql : " + sql);
	}
	
	@org.junit.Test
	@Ignore
	public void sessionTest() throws Exception {
		
		try(SqlSession session = sql.openSession()) {
			logger.info("session : " + session);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
