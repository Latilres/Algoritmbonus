/**
 * Returns int values with suitable padding
 *
 * @author LET375-39
 * @version 2017-06-01
 */

public class ConstantExpression implements Expression {
    private int value;
    public ConstantExpression( int value) {

        this.value = value;
    }

    @Override
    public int getValue() {
        return this.value;
    }

    @Override
    public void prettyInfix() {
        System.out.print(getValue());
    }

    @Override
    public void prettyPostfix() {
        System.out.print(getValue() + " ");
    }

    @Override
    public void prettyPrefix() {
        System.out.print(" " + getValue());
    }
}
