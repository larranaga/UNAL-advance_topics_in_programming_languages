// Generated from /Users/larra/Documents/11/lenguajes avanzados/UNAL-advance_topics_in_programming_languages/TL-parser/Grammar/TLv2.g4 by ANTLR 4.7
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TLv2Parser}.
 */
public interface TLv2Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TLv2Parser#tl}.
	 * @param ctx the parse tree
	 */
	void enterTl(TLv2Parser.TlContext ctx);
	/**
	 * Exit a parse tree produced by {@link TLv2Parser#tl}.
	 * @param ctx the parse tree
	 */
	void exitTl(TLv2Parser.TlContext ctx);
	/**
	 * Enter a parse tree produced by {@link TLv2Parser#valor}.
	 * @param ctx the parse tree
	 */
	void enterValor(TLv2Parser.ValorContext ctx);
	/**
	 * Exit a parse tree produced by {@link TLv2Parser#valor}.
	 * @param ctx the parse tree
	 */
	void exitValor(TLv2Parser.ValorContext ctx);
	/**
	 * Enter a parse tree produced by {@link TLv2Parser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(TLv2Parser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link TLv2Parser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(TLv2Parser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link TLv2Parser#main}.
	 * @param ctx the parse tree
	 */
	void enterMain(TLv2Parser.MainContext ctx);
	/**
	 * Exit a parse tree produced by {@link TLv2Parser#main}.
	 * @param ctx the parse tree
	 */
	void exitMain(TLv2Parser.MainContext ctx);
	/**
	 * Enter a parse tree produced by {@link TLv2Parser#funcion}.
	 * @param ctx the parse tree
	 */
	void enterFuncion(TLv2Parser.FuncionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TLv2Parser#funcion}.
	 * @param ctx the parse tree
	 */
	void exitFuncion(TLv2Parser.FuncionContext ctx);
	/**
	 * Enter a parse tree produced by {@link TLv2Parser#retorno_funcion}.
	 * @param ctx the parse tree
	 */
	void enterRetorno_funcion(TLv2Parser.Retorno_funcionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TLv2Parser#retorno_funcion}.
	 * @param ctx the parse tree
	 */
	void exitRetorno_funcion(TLv2Parser.Retorno_funcionContext ctx);
	/**
	 * Enter a parse tree produced by {@link TLv2Parser#instruccion}.
	 * @param ctx the parse tree
	 */
	void enterInstruccion(TLv2Parser.InstruccionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TLv2Parser#instruccion}.
	 * @param ctx the parse tree
	 */
	void exitInstruccion(TLv2Parser.InstruccionContext ctx);
	/**
	 * Enter a parse tree produced by {@link TLv2Parser#ifBlock}.
	 * @param ctx the parse tree
	 */
	void enterIfBlock(TLv2Parser.IfBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link TLv2Parser#ifBlock}.
	 * @param ctx the parse tree
	 */
	void exitIfBlock(TLv2Parser.IfBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link TLv2Parser#elseifBlock}.
	 * @param ctx the parse tree
	 */
	void enterElseifBlock(TLv2Parser.ElseifBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link TLv2Parser#elseifBlock}.
	 * @param ctx the parse tree
	 */
	void exitElseifBlock(TLv2Parser.ElseifBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link TLv2Parser#elseBlock}.
	 * @param ctx the parse tree
	 */
	void enterElseBlock(TLv2Parser.ElseBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link TLv2Parser#elseBlock}.
	 * @param ctx the parse tree
	 */
	void exitElseBlock(TLv2Parser.ElseBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link TLv2Parser#whileBlock}.
	 * @param ctx the parse tree
	 */
	void enterWhileBlock(TLv2Parser.WhileBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link TLv2Parser#whileBlock}.
	 * @param ctx the parse tree
	 */
	void exitWhileBlock(TLv2Parser.WhileBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link TLv2Parser#forBlock}.
	 * @param ctx the parse tree
	 */
	void enterForBlock(TLv2Parser.ForBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link TLv2Parser#forBlock}.
	 * @param ctx the parse tree
	 */
	void exitForBlock(TLv2Parser.ForBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link TLv2Parser#importar}.
	 * @param ctx the parse tree
	 */
	void enterImportar(TLv2Parser.ImportarContext ctx);
	/**
	 * Exit a parse tree produced by {@link TLv2Parser#importar}.
	 * @param ctx the parse tree
	 */
	void exitImportar(TLv2Parser.ImportarContext ctx);
	/**
	 * Enter a parse tree produced by {@link TLv2Parser#log}.
	 * @param ctx the parse tree
	 */
	void enterLog(TLv2Parser.LogContext ctx);
	/**
	 * Exit a parse tree produced by {@link TLv2Parser#log}.
	 * @param ctx the parse tree
	 */
	void exitLog(TLv2Parser.LogContext ctx);
	/**
	 * Enter a parse tree produced by {@link TLv2Parser#leer}.
	 * @param ctx the parse tree
	 */
	void enterLeer(TLv2Parser.LeerContext ctx);
	/**
	 * Exit a parse tree produced by {@link TLv2Parser#leer}.
	 * @param ctx the parse tree
	 */
	void exitLeer(TLv2Parser.LeerContext ctx);
	/**
	 * Enter a parse tree produced by {@link TLv2Parser#asignacion}.
	 * @param ctx the parse tree
	 */
	void enterAsignacion(TLv2Parser.AsignacionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TLv2Parser#asignacion}.
	 * @param ctx the parse tree
	 */
	void exitAsignacion(TLv2Parser.AsignacionContext ctx);
	/**
	 * Enter a parse tree produced by {@link TLv2Parser#arreglo}.
	 * @param ctx the parse tree
	 */
	void enterArreglo(TLv2Parser.ArregloContext ctx);
	/**
	 * Exit a parse tree produced by {@link TLv2Parser#arreglo}.
	 * @param ctx the parse tree
	 */
	void exitArreglo(TLv2Parser.ArregloContext ctx);
	/**
	 * Enter a parse tree produced by {@link TLv2Parser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExpresion(TLv2Parser.ExpresionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TLv2Parser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExpresion(TLv2Parser.ExpresionContext ctx);
}