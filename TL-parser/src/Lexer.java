import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;


import java.io.FileInputStream;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Lexer {
    private Set<String> keywords;
    private Map<String, String> operators;
    private Map<String, String> otherTokens;
    private String inputFilename, outputFilename;

    private static final int EOF_TYPE = -1;

    private void fillKeywords(){
        keywords = new TreeSet<>();
        keywords.add("log");
        keywords.add("while");
        keywords.add("for");
        keywords.add("if");
        keywords.add("function");
        keywords.add("in");
        keywords.add("retorno");
        keywords.add("end");
        keywords.add("true");
        keywords.add("false");
    }

    private void fillOperators(){
        operators = new TreeMap<>();
        operators.put("{", "token_llave_izq");
        operators.put("}", "token_llave_der");
        operators.put("[", "token_cor_izq");
        operators.put("]", "token_cor_der");
        operators.put("(", "token_par_izq");
        operators.put(")", "token_par_der");
        operators.put("<=", "token_menor_igual");
        operators.put(">=", "token_mayor_igual");
        operators.put("<", "token_menor");
        operators.put(">", "token_mayor");
        operators.put("==", "token_igual_num");
        operators.put(".", "token_point");
        operators.put("!=", "token_diff_num");
        operators.put("&&", "token_and");
        operators.put("||", "token_or");
        operators.put("!", "token_not");
        operators.put("+", "token_mas");
        operators.put("-", "token_menos");
        operators.put("*", "token_mul");
        operators.put("/", "token_div");
        operators.put("%", "token_mod");
        operators.put("^", "token_pot");
        operators.put("=", "token_assign");
        operators.put(",", "token_coma");
        operators.put(":", "token_dosp");
    }

    private void fillExtraTokens(){
        otherTokens = new TreeMap<>();
        otherTokens.put("INTEGERVALUE", "token_integer");
        otherTokens.put("STRINGVALUE", "token_string");
        otherTokens.put("FLOATVALUE", "token_float");
    }

    private String getToken(String str) throws Exception{
        if(otherTokens.containsKey(str))
            return otherTokens.get(str);
        throw new Exception("Undefined token, impossible to parse " + str);
    }

    private String identify(int type, Map<String, Integer> tokenType) throws Exception{
        for(Map.Entry<String, Integer> e: tokenType.entrySet()){
            if(type == e.getValue()){
                return getToken(e.getKey());
            }
        }
        return "eof";
    }
    private void setFiles(String inputFilename, String outputFilename){
        this.inputFilename = inputFilename;
        this.outputFilename = outputFilename;
    }

    public Lexer(){
        fillKeywords();
        fillOperators();
        fillExtraTokens();
    }

    public void generateOutput() throws Exception{
        ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(inputFilename));
        TLv1 lexer = new TLv1(input);


        StringBuilder output = new StringBuilder();
        Token token;
        while((token = lexer.nextToken()).getType() != EOF_TYPE ){
            if(token.getType() == EOF_TYPE)
                break;
            String lexema = token.getText();
            if(keywords.contains(lexema)){
                output.append("<").append(lexema);
            }
            else if(operators.containsKey(lexema)){
                output.append("<").append(operators.get(lexema));
            }
            else{
                try{
                    String tokenType = identify(token.getType(), lexer.getTokenTypeMap());
                    output.append("<")
                            .append(tokenType)
                            .append(",")
                            .append((tokenType.equals("token_string") ? lexema.replaceAll("\"", "") : lexema  ));
                } catch (Exception e){
                    output.append(">>> Error lexico (")
                            .append("linea: ")
                            .append(token.getLine())
                            .append(", posicion: ")
                            .append(token.getCharPositionInLine() + 1)
                            .append(")\n");

                    PrintWriter writer = new PrintWriter(outputFilename, "UTF-8");
                    writer.print(output);
                    writer.close();
                    return;
                }
            }
            output.append(",")
                    .append(token.getLine())
                    .append(",")
                    .append(token.getCharPositionInLine() + 1)
                    .append(">")
                    .append("\n");
        }
        PrintWriter writer = new PrintWriter(outputFilename, "UTF-8");
        writer.print(output);
        writer.close();
    }

    public static void main(String[] args) throws Exception {
        final int[] SAMPLES = {5, 5, 4, 4, 8};
        final int NUMBER_OF_EXAMPLES = 7;
        final String directory = "lexer-test-cases/";
        final String samples_directory = "samples/";
        final String inputPrefix = "in0";
        final String outputPrefix = "out0";
        final String extension = ".txt";

        Lexer lexerPractice = new Lexer();

        lexerPractice.setFiles("lexer-test-cases/single-input.txt", "lexer-test-cases/output.txt");
        lexerPractice.generateOutput();

        for(int i = 0; i < NUMBER_OF_EXAMPLES; ++i){
            lexerPractice.setFiles(directory + "/" + samples_directory + "/"
                            + inputPrefix + i + extension,
                            directory + "/" + samples_directory + "/" + outputPrefix + i + extension);
            lexerPractice.generateOutput();
        }
        /*for(char c = 'A'; c <= 'E'; c++){
            for(int i = 0 ; i < SAMPLES[(int)(c - 'A')]; i++){
                lexerPractice.setFiles(directory + "/" + String.valueOf(c) + "/"
                                         + inputPrefix + i + extension,
                                        directory + "/" + String.valueOf(c) + "/"
                                         + outputPrefix + i + extension);
                lexerPractice.generateOutput();
            }
        }*/
    }

}
