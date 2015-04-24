/**
 * Created by porrith on 4/20/15.
 * Do 10 / 2 + 1 * 2 = 5 * 2
 */
public class Main {
    public static void main(String[] args) {
        Calculation calculator = new Calculation();
        //GUI newCalc = new GUI(calculator);

        calculator.addInfix("10");
        calculator.addInfix("/");
        calculator.addInfix("2");
        calculator.addInfix("+");
        calculator.addInfix("1");
        calculator.addInfix("*");
        calculator.addInfix("2");

        calculator.printInfix();

        calculator.convertForm();

        System.out.println("\n");

        calculator.printPostfix();

        calculator.calculate();

        System.out.println("\nAnswer: " + calculator.returnAnswer());

    }
}
