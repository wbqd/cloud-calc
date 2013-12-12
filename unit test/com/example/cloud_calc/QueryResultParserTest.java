/**
 * 
 */
package com.example.cloud_calc;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Joshua
 * 
 */
public class QueryResultParserTest {
	
	public QueryResultParserTest() {}
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {}
	
	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {}
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {}
	
	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {}
	
	@Test
	public void test() {
		// QueryResultParser is tested
		QueryResultParser queryResultParserTester = new QueryResultParser(
				"sin x");
		
		// Check if it returns input "sin x"
		assertEquals("it returns input sin x", "sin(x)",
				queryResultParserTester.getQueryResultData().get(0)
						.getSubData().get(0).getPlainText());
	}
}
