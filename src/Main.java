/**
 * Created by porrith on 4/20/15.
 */
public class Main {
    public static void main(String[] args) {
        Calculation calculator = new Calculation();
        //GUI newCalc = new GUI(calculator);

        calculator.addInfix("10");
        calculator.addInfix("+");
        calculator.addInfix("2");
        calculator.addInfix("*");
        calculator.addInfix("8");
        calculator.addInfix("-");
        calculator.addInfix("3");

        calculator.printInfix();

        calculator.convertForm();

        System.out.println("\n");

        calculator.printPostfix();

    }
}
