package com.hotent;





import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;




@RunWith(JUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:conf/app-test.xml"})
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=false)
@Transactional
public class BaseTestCase {
	
	

	
	@Test
	public void Test(){}
	
	
	
	
}
