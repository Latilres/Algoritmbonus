import java.io.*;
import symbols.*;

/**
 * Parse simple binary expressions with parantheses
 *
 * @author LET375-39
 * @version 2017-06-01
 */

public class Main {

    public static void main(String[] args) {
        Expression testExpr =
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
                          new ConstantExpression( 5 ) ) );
        // B.1
         testExpr.prettyInfix();         System.out.println();
         testExpr.prettyPostfix();       System.out.println();
         testExpr.prettyPrefix();        System.out.println("/n");
        // B.2
         System.out.println(testExpr.getValue());
         
        // B.3
        Parser parse = new Parser(new InputStreamReader(System.in));
        try {
            Expression myExpression = parse.parse();
            System.out.print("Infix: ");
            myExpression.prettyInfix();
            System.out.print("\nPrefix: ");
            myExpression.prettyPrefix();
            System.out.print("\nPostfix: ");
            myExpression.prettyPostfix();
            System.out.println("\n- These expressions equals: " + myExpression.getValue());
        } catch (SyntaxError e){
            e.printStackTrace();
        }
    }
}
