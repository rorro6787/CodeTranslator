import java_cup.runtime.*;
%%

%cup
//%debug

%{
    TablaSimbolos tc = new TablaSimbolos();
%}

%%

\"([a-zA-Z]|[\\\"]*|u[0-9A-Fa-f]{4})+\"   { return new Symbol(sym.PALABRA, yytext()); }

// Palabras reservadas:

"if"                    { return new Symbol(sym.IF);    }
"else"                  { return new Symbol(sym.ELSE);  }
"do"                    { return new Symbol(sym.DO);    }
"while"                 { return new Symbol(sym.WHILE); }
"for"                   { return new Symbol(sym.FOR);   }
"print"                 { return new Symbol(sym.PRINT); }

// Paréntesis:

"("                     { return new Symbol(sym.AP); }
")"                     { return new Symbol(sym.CP); }
"["                     { return new Symbol(sym.AC); }
"]"                     { return new Symbol(sym.CC); }
"{"                     { return new Symbol(sym.AL); }
"}"                     { return new Symbol(sym.CL); }
 
// Operadores lógicos
"from"              { return new Symbol(sym.FROM); }
"to"                    { return new Symbol(sym.TO); }
"step"              { return new Symbol(sym.STEP); }
"forall"                { return new Symbol(sym.FORALL); }
"exists"           { return new Symbol(sym.EXISTS); }
"-->"                    { return new Symbol(sym.IMPLICA); }
"<-->"   { return new Symbol(sym.DIMPLICA); }
"=="                    { return new Symbol(sym.EQ);  }
"!="                    { return new Symbol(sym.NE);  }
"<="                    { return new Symbol(sym.LE);  }
"<"                     { return new Symbol(sym.LT);  }
">="                    { return new Symbol(sym.GE);  }
">"                     { return new Symbol(sym.GT);  }
"&&"                    { return new Symbol(sym.AND); }
"||"                    { return new Symbol(sym.OR);  }
"!"                     { return new Symbol(sym.NOT); }

// Operadores aritméticos

"+"                     { return new Symbol(sym.MAS); }
"-"                     { return new Symbol(sym.MENOS); }
"*"                     { return new Symbol(sym.POR); }
"/"                     { return new Symbol(sym.DIV); }
"="                     { return new Symbol(sym.IGUAL); }

// Punto y coma:

";"                     { return new Symbol(sym.PYC);  }
","                     { return new Symbol(sym.COMA); }
"."                     { return new Symbol(sym.PUNTO); }

// Valores

[0-9]+                  { return new Symbol(sym.NUMERO, yytext()); }
[0-9](\.)([0-9]+)(E(\-)([0-9]+))?       { return new Symbol(sym.REAL, yytext());  }
"char"                  { return new Symbol(sym.CHAR, yytext()); }
"int"                   { return new Symbol(sym.INT, yytext());              }
"float"                { return new Symbol(sym.FLOAT, yytext());           }
"string"               { return new Symbol(sym.STRING, yytext()); }
"length"               { return new Symbol(sym.LENGTH); }
"boolean"              { return new Symbol(sym.BOOLEAN, yytext()); }
\(int\)(\s)*[_a-zA-Z][_a-zA-Z0-9]* { return new Symbol(sym.CASTI, yytext()); }
true|false             { return new Symbol(sym.VERDAD, yytext()); }
[_a-zA-Z][_a-zA-Z0-9]*(\s)*\=(\s)*\(boolean\)   { return new Symbol(sym.CASTB, yytext()); }
[_a-zA-Z][_a-zA-Z0-9]*  { String aux = tc.buscar(yytext());
                            if(aux == null || !aux.equals("boolean")) {
                                return new Symbol(sym.VAR, yytext());
                            }
                            else {
                                return new Symbol(sym.BVAR, yytext());
                            }
                      }
'\\.'|'[^\\\']'        { return new Symbol(sym.LETRA, yytext()); }
\\u[0-9a-fA-F]{4}      { return new Symbol(sym.UNICODE, yytext()); }

// Otra cosa

[^]                     { }