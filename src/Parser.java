import java.io.Reader;
import symbols.*;

/**
 * Parse simple binary expressions with parantheses
 * 
 * @author ____________
 * @version 2017-05-27
 */
public class Parser {
    private SymbolReader symbolReader;
    
    public Parser( Reader inStream ) {
        symbolReader = new SymbolReader(inStream);
    }

    /*
    public Expression parse() throws SyntaxError {
        return parseExpression(symbolReader.readNextSymbol());
    }*/
        
    // ...
}
