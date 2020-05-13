package com.cg.testmgmt.service;

import com.cg.testmgmt.service.TestServiceImpl;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
@Import(TestServiceImpl.class)
@ExtendWith(SpringExtension.class)// integrate spring test framework with junit5
public class TestManagementServiceImplTest {
	
	@Autowired
	private TestServiceImpl service;
	@Autowired
	private EntityManager entityManager;
	
	@Test
	public void testAddTest() {
		BigInteger testId;
		testId = BigInteger.valueOf(1);
		String testTitle = "java";
		com.cg.testmgmt.entities.Test test = new com.cg.testmgmt.entities.Test();
		test.setTestTitle(testTitle);
		test.setTestId(testId);
		com.cg.testmgmt.entities.Test result = service.addTest(test);
		List<com.cg.testmgmt.entities.Test> fetched = entityManager.createQuery("from Test").getResultList();
		Assertions.assertEquals(1, fetched.size());// verifying one got inserted
		com.cg.testmgmt.entities.Test expected = fetched.get(0);
		Assertions.assertEquals(expected, result);// verifying fetch and stored are equal
		Assertions.assertEquals(testTitle, expected.getTestTitle());
		Assertions.assertEquals(testId, expected.getTestId());

	}

}
