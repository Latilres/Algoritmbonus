import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import symbols.SymbolTypes;

import java.io.*;


class ParserTest {
    Parser toTest;
    Expression myExpression;

    @BeforeEach
    void setUp() throws SyntaxError {
        String input = "(((1+2)^3)-(4*5))";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        toTest = new Parser(new InputStreamReader(System.in));
        try {
            myExpression = toTest.parse();
        } catch (SyntaxError syntaxError) {
            syntaxError.printStackTrace();
        }

    }

/*    @AfterEach
    void tearDown() {

    }*/

    @Test
    void parse() {
        String input = "(((1+2)^3)-(4*5))";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Expression testExpr;
        assertEquals( testExpr =
                new BinaryExpression(
                        new BinaryExpression(
                                new BinaryExpression(
                                        new ConstantExpression( 1 ),
                                        SymbolTypes.PLUS,
                                        new ConstantExpression( 2 ) ),
                                SymbolTypes.EXP,
                                new ConstantExpression( 3 ) ),
                        SymbolTypes.MINUS,
                        new BinaryExpression(
                                new ConstantExpression( 4 ),
                                SymbolTypes.MULT,
                                new ConstantExpression( 5 ) ) ), System.in);
    }

}