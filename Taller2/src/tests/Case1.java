package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import junit.framework.Assert;
import parser.ParserPractice;

class Case1 {
	ParserPractice parser;
	
	String readFile(String fileName) throws Exception {
		BufferedReader expected = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
		StringBuilder expectedString = new StringBuilder();
		String s;
		while( (s = expected.readLine()) != null ) {
			expectedString.append(s);
		}
		return expectedString.toString();
	}
	
	void testFile(String in, String out) throws Exception {
		parser.setFiles(in);
		String expected = readFile(out);
		String actual = parser.generateOutput();
		if(!expected.equals(actual)) {
			System.out.println(expected);
			System.out.println("######");
			System.out.println(actual);
		}
		Assert.assertEquals(expected, actual);
	}
	
	@BeforeEach
	void setUp() throws Exception {
		System.setErr(new PrintStream(new OutputStream() {
		    public void write(int b) {
		    }
		}));
		
		parser = new ParserPractice();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testCase1() throws Exception {
		testFile("test_cases/1/in01.txt", "test_cases/1/out01.txt");
		testFile("test_cases/1/in04.txt", "test_cases/1/out04.txt");
	}

	@Test
	void testCase2() throws Exception {
		testFile("test_cases/2/in02.txt", "test_cases/2/out02.txt");
		testFile("test_cases/2/in03.txt", "test_cases/2/out03.txt");
	}
	
	@Test
	void testCase3() throws Exception {
		testFile("test_cases/3/in02.txt", "test_cases/3/out02.txt");
		testFile("test_cases/3/in03.txt", "test_cases/3/out03.txt");
	}

	@Test
	void testCase4() throws Exception {
		testFile("test_cases/4/in03.txt", "test_cases/4/out03.txt");
		testFile("test_cases/4/in04.txt", "test_cases/4/out04.txt");
	}
	
	@Test
	void testCase5() throws Exception {
		testFile("test_cases/5/in01.txt", "test_cases/5/out01.txt");
		testFile("test_cases/5/in02.txt", "test_cases/5/out02.txt");
		testFile("test_cases/5/in04.txt", "test_cases/5/out04.txt");
	}
}
