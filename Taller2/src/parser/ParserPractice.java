package parser;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.InputMismatchException;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.misc.IntervalSet;

import gen.TLv2Lexer;
import gen.TLv2Parser;

import java.io.FileInputStream;
import java.io.PrintWriter;
import java.util.*;

public class ParserPractice {
    private String inputFilename;
    private boolean syntaxErrorFound;

    public void setFiles(String inputFilename){
        this.inputFilename = inputFilename;
        syntaxErrorFound = false;
    }


    public void generateOutput() throws Exception {
        ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(inputFilename));
        TLv2Lexer lexer = new TLv2Lexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        TLv2Parser parser = new TLv2Parser(tokens);

        final PrintWriter writer = new PrintWriter(System.out);//new PrintWriter(outputFilename, "UTF-8");

        parser.setErrorHandler(new DefaultErrorStrategy(){

            protected String elementName(Vocabulary vocabulary, int tokenCode){
                if(tokenCode == -1){
                    return "EOF";
                }
                if(tokenCode == -2){
                    return "EPS";
                }
                return vocabulary.getDisplayName(tokenCode);
            }

            protected String elementName(String name){
                if(name.equals("\'<EOF>\'")){
                    return "\'EOF\'";
                }
                return name;
            }

            private String reportSyntaxError(Token token, Parser recognizer){
                String tokenName = this.getTokenErrorDisplay(token);
                IntervalSet expecting = this.getExpectedTokens(recognizer);
                TreeSet<String> expectedTokens = new TreeSet<>();

                //Adapted from org.antlr.v4.runtime.misc.IntervalSet.toString(Vocabulary)
                if(expecting.getIntervals() != null && !expecting.getIntervals().isEmpty()){
                    Iterator<Interval> iter = expecting.getIntervals().iterator();
                    while(iter.hasNext()){
                        Interval I = (Interval) iter.next();
                        int a = I.a;
                        int b = I.b;
                        for(int i = a; i <=b; i++){
                            String name = elementName(recognizer.getVocabulary(), i);
                            if(name.indexOf('\'') == -1){
                                if(name.equals("ID")){
                                    name = "identificador";
                                }
                                name = "\'" + name + "\'";
                            }
                            if(name.equals("\'EOF\'"))
                                expectedTokens.add(name);
                            else if(name.equals("\'DOUBLEVALUE\'")) {
                                expectedTokens.add("\'valor_double\'");
                            }
                            else if(name.equals("\'INTEGERVALUE\'")){
                                expectedTokens.add("\'valor_entero\'");
                            }
                            else if(name.equals("\'STRINGVALUE\'")){
                                expectedTokens.add("\'valor_string\'");
                            }
                            else{
                                expectedTokens.add(name);
                            }
                        }
                    }
                }
                StringBuilder expectedBuffer = new StringBuilder();
                boolean comma = false;
                for(String tokenString : expectedTokens){
                    if(comma) expectedBuffer.append(", ");
                    expectedBuffer.append(tokenString);
                    comma = true;
                }

                String msg = "<" + token.getLine() + "," + (token.getCharPositionInLine() + 1) + "> Error sintactico "
                        + "se encontro: " + elementName(tokenName) + "; se esperaba: "
                        + expectedBuffer + ".";

                if(!syntaxErrorFound){
                    syntaxErrorFound = true;
                    writer.print(msg);
                    writer.close();
                }
                return msg;
            }

            private void reportTokens(Parser recognizer){
                if(!this.inErrorRecoveryMode(recognizer)) {
                    this.beginErrorCondition(recognizer);
                    Token token = recognizer.getCurrentToken();
                    String msg = reportSyntaxError(token, recognizer);
                    recognizer.notifyErrorListeners(token, msg, (RecognitionException)null);
                }
            }

            @Override
            protected void reportUnwantedToken(Parser recognizer) {
                reportTokens(recognizer);
            }


            @Override
            protected void reportMissingToken(Parser recognizer) {
                reportTokens(recognizer);
            }

            @Override
            protected void reportInputMismatch(Parser recognizer, InputMismatchException e) {
                String msg = reportSyntaxError(e.getOffendingToken(), recognizer);
                recognizer.notifyErrorListeners(e.getOffendingToken(), msg, e);
            }

            @Override
            protected void reportNoViableAlternative(Parser recognizer, NoViableAltException e) {
                String msg = reportSyntaxError(e.getOffendingToken(), recognizer);
                recognizer.notifyErrorListeners(e.getOffendingToken(), msg, e);
            }
        });

        parser.tl();

        if(!syntaxErrorFound){
            writer.print("El analisis sintactico ha finalizado correctamente.");
            writer.close();
        }
    }
}