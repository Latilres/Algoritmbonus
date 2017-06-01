import java.io.Reader;

import symbols.*;

/**
 * Parse simple binary expressions with parantheses
 *
 * @author LET375-39
 * @version 2017-06-01
 */
public class Parser {
    private SymbolReader symbolReader;
    
    public Parser( Reader inStream ) {
        symbolReader = new SymbolReader(inStream);
    }


    public Expression parse() throws SyntaxError {
        Symbol s = symbolReader.readNextSymbol();

        return parseExpression(s);
    }

    /**
     * Gets symbols from user input and builds a syntax three from it.
     * @param nextSymbol the symbols to parse
     * @return an expression or the value of nextSymbol
     * @throws SyntaxError when nextSymbol contains an unexpected value
     */
    private Expression parseExpression(Symbol nextSymbol) throws SyntaxError{
        switch( nextSymbol.getType() ) {
            case RPAREN:
                throw new SyntaxError("There is nothing in an expression");
            // if nextSymbol = "("
            case LPAREN:
                //parseExpression for next symbol
                Expression left = parseExpression(symbolReader.readNextSymbol());

                //go to the next symbolType
                SymbolTypes op = symbolReader.readNextSymbol().getType();
                //op is not a type between EXP and MINUS
                if( !SymbolTypes.isBinary(op) )
                    throw new SyntaxError("SyntaxError: illegal operator encountered");

                //parseExpression for next symbol
                Expression right = parseExpression(symbolReader.readNextSymbol());

                //controls that the expression ends with )
                if( symbolReader.readNextSymbol().getType() != SymbolTypes.RPAREN )
                    throw new SyntaxError("SyntaxError: ')' expected");

                return new BinaryExpression(left, op, right);
            // if nextSymbol is a number
            case VALUE:
                return new ConstantExpression( nextSymbol.getValue() );
            // if nextSymbol isn't a number or "("
            default:
                throw new SyntaxError("SyntaxError: number or '(' expected");
        }
    }
}
