package parser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import gen.TLv2Lexer;
import gen.TLv2Parser;

public class Parser {
	
	private static String test = "test_cases/1/in01.txt";
	
	public static void main(String[] args) {
		try {
	        ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(test));
	        TLv2Lexer lexer = new TLv2Lexer(input);
	        CommonTokenStream tokens = new CommonTokenStream(lexer);
	        TLv2Parser parser = new TLv2Parser(tokens);
	        ParseTree tree = parser.tl();
	        System.out.println("El analisis sintactico ha finalizado correctamente.");
        } catch (Exception e) {
			e.printStackTrace();
		}	
	}
}
