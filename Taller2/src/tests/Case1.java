package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import parser.ParserPractice;

class Case1 {
	ParserPractice parser;
	FileInputStream expected, actual;
	
	@BeforeEach
	void setUp() throws Exception {
		parser = new ParserPractice();
	}

	@AfterEach
	void tearDown() throws Exception {
		expected.close();
		actual.close();
	}

	@Test
	void testCase1_1() throws Exception {
		parser.setFiles("test_cases/1/in01.txt", "out.txt");
		expected = new FileInputStream(new File("test_cases/1/out01.txt"));
		actual = new FileInputStream(new File("out.txt"));
		parser.generateOutput();
	}

}
