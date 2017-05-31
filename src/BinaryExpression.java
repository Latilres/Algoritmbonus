import symbols.*;

public class BinaryExpression implements Expression {
    private SymbolTypes op;
    private Expression leftOperand;
    private Expression rightOperand;

    public BinaryExpression( Expression leftOperand, SymbolTypes op, Expression rightOperand ) {
        this.leftOperand = leftOperand;
        this.op = op;
        this.rightOperand = rightOperand;
    }

    // ...
}
