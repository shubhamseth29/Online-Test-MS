package com.cg.testmgmt;

import com.cg.testmgmt.service.ITestService;
import com.cg.testmgmt.service.IUserService;
import com.cg.testmgmt.service.TestServiceImpl;
import com.cg.testmgmt.service.UserServiceImpl;

import java.math.BigInteger;
import java.util.List;
import javax.persistence.EntityManager;
import com.cg.testmgmt.exception.TestNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
@DataJpaTest
@ExtendWith(SpringExtension.class)// integrate spring test framework with junit5
@Import({TestServiceImpl.class,UserServiceImpl.class})

// importing TestServiceImpl class as @DatajpaTest will only search for repositories

public class TestManagementServiceImplTest {
	
	@Autowired
	private IUserService userService;
	@Autowired
	private ITestService service;
	@Autowired
	private EntityManager entityManager;
	@Test
	public void testAddTest_1() 
	{
		BigInteger testId;
		testId = BigInteger.valueOf(10);
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

	@Test
	public void testDeleteTest_1() {
		BigInteger testId;
		testId = BigInteger.valueOf(10);
		String testTitle = "java";
		com.cg.testmgmt.entities.Test test = new com.cg.testmgmt.entities.Test();
		test.setTestTitle(testTitle);
		test.setTestId(testId);
		test = service.addTest(test);
		com.cg.testmgmt.entities.Test result = service.deleteTest(testId);

		Assertions.assertEquals(result.getTestId(), test.getTestId());// verifying fetch and stored are equal
		Assertions.assertEquals(result.getTestTitle(), test.getTestTitle());

	}

	  @Test
	    public void testDeleteTest_2()
	    {
	        Executable executable = () -> service.deleteTest(BigInteger.valueOf(25));
	        Assertions.assertThrows(TestNotFoundException.class, executable);

	    }
	@Test
	public void testFindById_1() 
	 {
		BigInteger id;
		id = BigInteger.valueOf(16);
		Executable executable = () -> service.findById(id);
		Assertions.assertThrows(TestNotFoundException.class, executable);
	}

	@Test
	public void testFindByTestId_1() {
		
		BigInteger testId;
		testId = BigInteger.valueOf(100);
		String testTitle = "java";
		com.cg.testmgmt.entities.Test test = new com.cg.testmgmt.entities.Test();
		test.setTestTitle(testTitle);
		test.setTestId(testId);
		test = service.addTest(test);

		com.cg.testmgmt.entities.Test result = service.findById(testId);

		Assertions.assertEquals(test, result);
		Assertions.assertEquals(testId, result.getTestId());
	}

}