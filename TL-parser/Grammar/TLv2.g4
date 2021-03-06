grammar TLv2;


tl                      :   funcion* main EOF;


//auxiliary rules (not a part of main grammar)

valor                   :   variable
                        |   STRINGVALUE
                        |   INTEGERVALUE
                        |   FLOATVALUE
                        |   TRUE
                        |   FALSE
                        ;

variable                :   ID ('[' valor ']') ? ;


//main grammar

main                    :   instruccion*;

funcion                 :   FUNCION ID '(' ID ? (',' ID)* ')' instruccion* retorno_funcion ? END FUNCION;


retorno_funcion         :   RETORNO expresion;
instruccion             :   ifBlock
                        |   whileBlock
                        |   importar
                        |   log
                        |   leer
                        |   forBlock
                        |   asignacion
                        ;

ifBlock                      :   IF '(' expresion ')' instruccion * elseifBlock* elseBlock ? ;

elseifBlock                  :   ELSE IF '(' expresion ')' instruccion* ;

elseBlock                    :   ELSE instruccion* ;

whileBlock                   :   WHILE '(' expresion ')' instruccion* ;

forBlock                     :   FOR ID IN (arreglo | ID) '{' instruccion* '}' ;

importar                :   IMPORTAR ID ( '.' ID)*
                        |   DESDE ID IMPORTAR ID
                        ;

log                     :   LOG '(' expresion ')';

leer                    :   LEER '(' variable ')';

asignacion              :   variable '=' expresion;


arreglo                 :   '[' INTEGERVALUE ? ( ',' INTEGERVALUE) * ']' EOF ;


expresion               :   value=(INTEGERVALUE | FLOATVALUE | STRINGVALUE | TRUE | FALSE)
                        |   variable
                        |   '(' expresion ')'
                        |   op=('-' | '!') expresion
                        |   expresion '^' expresion
                        |   expresion op=('/' | '*' | '%') expresion
                        |   expresion op=('+' | '-') expresion
                        |   expresion op=('<' | '<=' | '>' | '>=') expresion
                        |   expresion op=('==' | '!=') expresion
                        |   expresion '&&' expresion
                        |   expresion '||' expresion
                        ;

//Reserved words
LOG:        'log';
LEER:       'leer';
WHILE:      'while';
FOR:        'for';
IF:         'if';
ELSE:       'else';
FUNCION:   'funcion';
IN:         'in';
RETORNO:    'retorno';
END:        'end';
TRUE:       'true';
FALSE:      'false';
IMPORTAR:   'importar';
DESDE:      'desde';
TODO:       'todo';
NIL:        'nil';


//Lexems

STRINGVALUE         :   '"' ( '\\' ('\\'|'\t'|'\r\n'|'\r'|'\n'|'"') | ~('\\'|'\t'|'\r'|'\n'|'"') )* '"';

INTEGERVALUE        :   [0-9][0-9]*;

FLOATVALUE          :   [0-9]+'.'[0-9]+;

//floats, strings, integers, bool

//Tokens

ID      :   [a-zA-Z_][a-zA-Z0-9_]*;
WS      :   [ \n\t\r]+ -> skip;
COMMENT : '#' ~[\r\n]* -> skip;


ERRORCHARACTER: . ;
