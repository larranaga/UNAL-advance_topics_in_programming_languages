lexer grammar TLv1;


//Reserved words
LOG:        'log';
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
TOKEN_LLAVE_IZQ:    '{';
TOKEN_LLAVE_DER:    '}';
TOKEN_COR_IZQ:      '[';
TOKEN_COR_DER:      ']';
TOKEN_PAR_IZQ:      '(';
TOKEN_PAR_DER:      ')';
TOKEN_MENOR_IGUAL:  '<=';
TOKEN_MAYOR_IGUAL:  '>=';
TOKEN_MAYOR:        '>';
TOKEN_MENOR:        '<';
TOKEN_IGUAL_NUM:    '==';
TOKEN_POINT:        '.';
TOKEN_DIFF_NUM:     '!=';
TOKEN_AND:          '&&';
TOKEN_OR:           '||';
TOKEN_NOT:          '!';
TOKEN_MAS:          '+';
TOKEN_MENOS:        '-';
TOKEN_MUL:          '*';
TOKEN_DIV:          '/';
TOKEN_MOD:          '%';
TOKEN_POT:          '^';
TOKEN_ASSIGN:       '=';
TOKEN_COMA:         ',';
TOKEN_DOSP:         ':';

ID      :   [a-zA-Z_][a-zA-Z0-9_]*;
WS      :   [ \n\t\r]+ -> skip;
COMMENT : '#' ~[\r\n]* -> skip;


ERRORCHARACTER: . ;
