import symbols.*;

/**
 * Prints different arithmetic expressions from given input
 *
 * @author LET375-39
 * @version 2017-06-01
 */

public class BinaryExpression implements Expression {
    private SymbolTypes op;
    private Expression leftOperand;
    private Expression rightOperand;

    public BinaryExpression( Expression leftOperand, SymbolTypes op, Expression rightOperand ) {
        this.leftOperand = leftOperand;
        this.op = op;
        this.rightOperand = rightOperand;
    }

    // Checks the operator and reacts accordingly
    @Override
    public int getValue() {
        switch (op) {
            case PLUS:
                return leftOperand.getValue() + rightOperand.getValue();
            case MINUS:
                return leftOperand.getValue() - rightOperand.getValue();
            case MULT:
                return leftOperand.getValue() * rightOperand.getValue();
            case DIV:
                if (rightOperand.getValue() == 0) {
                    throw new ArithmeticException("Dividing by zero is not allowed!");
                }
                return leftOperand.getValue() / rightOperand.getValue();
            case MOD:
                if (rightOperand.getValue() == 0){
                    throw new ArithmeticException("Modulo by zero is not allowed!");
                }
                return leftOperand.getValue() % rightOperand.getValue();
            case EXP:
                return (int) Math.pow(leftOperand.getValue(), rightOperand.getValue());
        }
        return 0;
    }

    @Override
    public void prettyInfix() {
        //start the expression
        System.out.print("(");
        //start a new expression with leftOperand
        leftOperand.prettyInfix();
        //print the operator
        System.out.print(op.opChar);
        //start a new expression with rightOperand
        rightOperand.prettyInfix();
        //end the expression
        System.out.print(")");
    }
    // The other works similarly and are therefore not commented

    @Override
    public void prettyPostfix() {
        System.out.print("(");
        leftOperand.prettyPostfix();
        rightOperand.prettyPostfix();
        System.out.print(op.opChar);
        System.out.print(")");
    }

    @Override
    public void prettyPrefix() {
        System.out.print("(");
        System.out.print(op.opChar);
        leftOperand.prettyPrefix();
        rightOperand.prettyPrefix();
        System.out.print(")");
    }
}
