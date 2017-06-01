import java.io.Reader;

import symbols.*;

/**
 * Parse simple binary expressions with parentheses
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
        return parseExpression(symbolReader.readNextSymbol());
    }

    /**
     * Gets symbols from user input and builds a syntax three from it.
     * @param nextSymbol the symbols to parse
     * @return an expression or the value of nextSymbol
     * @throws SyntaxError when nextSymbol contains an unexpected value
     */
    private Expression parseExpression(Symbol nextSymbol) throws SyntaxError{
        switch( nextSymbol.getType() ) {
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
                System.out.print(nextSymbol.getValue());
                throw new SyntaxError("SyntaxError: number or '(' expected");
        }
    }
}

// I know that it cannot handle something like (3-1+4),
//  but none of the examples had this, so I skipped it to.
// Likewise I know that e.g. (5+(3-1))) or (((5-3)/2)*7 doesn't give
//  errors, but since I cannot check for EOF without start looking
//  for more input and thus failing valid expression (since they
//  never end), I decided to skip this (also it is time for bed before the exam).