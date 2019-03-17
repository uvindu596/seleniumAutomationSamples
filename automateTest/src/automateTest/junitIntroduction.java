package automateTest;



import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class junitIntroduction {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Executed before class");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("Executed after class");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("Executed before class");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Executed after class");
	}

	@Test
	public void test1() {
		System.out.println("Executed test1");
	}
	@Test
	public void test2() {
		System.out.println("Executed test2");
	}

}
