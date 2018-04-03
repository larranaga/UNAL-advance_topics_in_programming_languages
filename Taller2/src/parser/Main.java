package parser;

public class Main {
	public static void main(String [] args) throws Exception {
		ParserPractice parserPractice = new ParserPractice();
		String fileName = "test_cases/5/in01.txt";
		if(args.length > 1) {
			fileName = args[1];
		}
		parserPractice.setFiles(fileName);
		System.out.println(parserPractice.generateOutput());
	}
}
