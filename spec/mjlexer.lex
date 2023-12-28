
package rs.ac.bg.etf.pp1;

import java_cup.runtime.Symbol;

%%

%{
    //ukljucivanje informacije o poziciji tokena
    private Symbol new_symbol(int type){
        return new Symbol(type, yyline+1, yycolumn);
    }

    //ukljucivanje informacije o vrednosti tokena
    private Symbol new_symbol(int type, Object value){
        return new Symbol(type, yyline+1, yycolumn,value);
    }
%}

%cup
%line
%column

%state COMMENT

%eofval{
    return new_symbol(sym.EOF);
%eofval}

%%

" "     { }
"\b"    { }
"\t"    { }
"\r\n"  { }
"\f"    { }

"program"   { return new_symbol(sym.PROG, yytext());}
"break" 	{ return new_symbol(sym.BREAK, yytext()); }
"class" 	{ return new_symbol(sym.CLASS, yytext()); }
"else" 	    { return new_symbol(sym.ELSE, yytext()); }
"const" 	{ return new_symbol(sym.CONST, yytext()); }
"if" 	    { return new_symbol(sym.IF, yytext()); }
"new" 	    { return new_symbol(sym.NEW, yytext()); }
"print" 	{ return new_symbol(sym.PRINT, yytext()); }
"read" 	    { return new_symbol(sym.READ, yytext()); }
"return" 	{ return new_symbol(sym.RETURN, yytext()); }
"void" 	    { return new_symbol(sym.VOID, yytext()); }
"extends" 	{ return new_symbol(sym.EXTENDS, yytext()); }
"continue" 	{ return new_symbol(sym.CONTINUE, yytext()); }
"for" 	    { return new_symbol(sym.FOR, yytext()); }
"static" 	{ return new_symbol(sym.STATIC, yytext()); }
"namespace" { return new_symbol(sym.NAMESPACE, yytext()); }
"*" 		{ return new_symbol(sym.MUL, yytext()); }
"/" 		{ return new_symbol(sym.DIV, yytext()); }
"%" 		{ return new_symbol(sym.MOD, yytext()); }
"==" 		{ return new_symbol(sym.EQUAL, yytext()); }
"!=" 		{ return new_symbol(sym.NOTEQUAL, yytext()); }
">" 		{ return new_symbol(sym.GRT, yytext()); }
">=" 		{ return new_symbol(sym.GRTE, yytext()); }
"<" 		{ return new_symbol(sym.LSS, yytext()); }
"<=" 		{ return new_symbol(sym.LSSE, yytext()); }
"&&" 		{ return new_symbol(sym.BITAND, yytext()); }
"||" 		{ return new_symbol(sym.BITOR, yytext()); }
"=" 		{ return new_symbol(sym.ASSIGN, yytext()); }
"++" 		{ return new_symbol(sym.PLUSPLUS, yytext()); }
"--" 		{ return new_symbol(sym.MINUSMINUS, yytext()); }
"+" 		{ return new_symbol(sym.PLUS, yytext()); }
"-" 		{ return new_symbol(sym.MINUS, yytext()); }
";" 		{ return new_symbol(sym.SEMI, yytext()); }
":" 		{ return new_symbol(sym.COLON, yytext()); }
"," 		{ return new_symbol(sym.COMMA, yytext()); }
"." 		{ return new_symbol(sym.DOT, yytext()); }
"(" 		{ return new_symbol(sym.LPAREN, yytext()); }
")" 		{ return new_symbol(sym.RPAREN, yytext()); }
"[" 		{ return new_symbol(sym.LSQUARE, yytext()); }
"]" 		{ return new_symbol(sym.RSQUARE, yytext()); }
"{" 		{ return new_symbol(sym.LBRACE, yytext()); }
"}"			{ return new_symbol(sym.RBRACE, yytext()); }
"=>"		{ return new_symbol(sym.LAMBDA, yytext()); }

"//"                {yybegin(COMMENT);}
<COMMENT> "\n"    {yybegin(YYINITIAL);}
<COMMENT> "\r"    {yybegin(YYINITIAL);}
<COMMENT> .         {yybegin(COMMENT);}

[a-zA-Z][a-zA-Z0-9_]* 	{return new_symbol (sym.IDENT, yytext()); }
'[\x20-\x7E]'         { return new_symbol(sym.CHARCONST, new Character ((yytext()).charAt(0))); }
[0-9]+              { return new_symbol(sym.NUMCONST, new Integer (yytext())); }
"true"  { return new_symbol(sym.BOOLCONST, new Boolean (yytext())); }
"false"  { return new_symbol(sym.BOOLCONST, new Boolean (yytext())); }

. { System.err.println("Leksicka greska ("+yytext()+") u liniji "+(yyline+1)); }

