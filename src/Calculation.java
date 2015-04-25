import javax.swing.*;
import java.util.Stack;
import java.util.Vector;

/**
 * Created by porrith on 4/20/15.
 * Must convert infix to postfix
 * 2 * 3 * 6 / 3 = 2363**\/
 */
public class Calculation {

    private double memory, result;

    private Vector<String>infixNotation; //Stores the prefix notation placed into the calculator
    private Vector<String>postfixNotation; //Stores the postfix notation
    private Stack<String>operators; //stores the operators to convert infix notation to postfix notation

    private Stack<Double>operands; //stack used for operand calculation

    public Calculation()
    {
        memory = 0.0;
        infixNotation = new Vector<String>();
        postfixNotation = new Vector<String>();
        operators = new Stack<String>();
        operands = new Stack<Double>();
    }

    public void setMemory(String memoryVal)
    {
        memory = Double.parseDouble(memoryVal);
    }

    public double getMemory() { return memory; }

    public void addInfix(String s)
    {
        infixNotation.add(s);
    }

    public void checkLast() //checks the last element for doubles
    {
        try
        {
            Double.parseDouble(infixNotation.lastElement());
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Cannot have consecutive operators!");
        }
    }

    private boolean checkString(String s)
    {
        try{
            Double.parseDouble(s);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    //prints out the vector
    public void printInfix()
    {
        for (int i = 0; i < infixNotation.size(); i++) {
            System.out.println(infixNotation.elementAt(i));
        }
    }

    public void convertForm()
    {
        String s;
        for (int i = 0; i < infixNotation.size(); i++) {
            s = infixNotation.elementAt(i);
            if (checkString(s))
            {
                postfixNotation.add(s);
            }
            else if (operators.isEmpty() || operators.peek() == "(" || s == "(")
                operators.push(s);
            else if (s == ")")
            {
                while(operators.peek() != "(")
                {
                    postfixNotation.add(operators.pop());
                }
                if (operators.peek() == "(")
                    operators.pop();
            }
            else if (s == "*" || s == "/")
            {
                if (operators.peek() == "*" || operators.peek() == "/")
                {
                    postfixNotation.add(operators.pop());
                    operators.push(s);
                }
                else
                {
                    operators.push(s);
                }
            }
            else if (s == "+" || s == "-")
            {
                if (operators.peek() == "*" || operators.peek() == "/")
                {
                    System.out.println(true);
                    while(!operators.isEmpty())
                    {
                        if(operators.peek() != "+" || operators.peek() != "-")
                            postfixNotation.add(operators.pop());
                    }
                    operators.push(s);
                }
                else if (operators.peek() == "+" || operators.peek() == "-")
                {
                    System.out.println("Second condition: " + true);
                    postfixNotation.add(operators.pop());
                    operators.push(s);
                }
                else
                {
                    System.out.println("Third condition: " + true);
                    operators.push(s);
                }
            }
        }
        while (operators.size() > 0)
        {
            postfixNotation.add(operators.pop());
        }
    }

    public void printPostfix()
    {
        for (int i = 0; i < postfixNotation.size(); i++) {
            System.out.println(postfixNotation.elementAt(i));
        }
    }

    public double calculate()
    {
        String s;
        double a, b; //temporarily store the operands for calculation
        for (int i = 0; i < postfixNotation.size(); i++) {
            s = postfixNotation.elementAt(i);
            if (checkString(s))
            {
                operands.push(Double.parseDouble(s));
            }
            else if (!checkString(s))
            {
                if (s == "*")
                {
                    b = operands.pop();
                    a = operands.pop();
                    operands.push(a * b);
                    //System.out.println(operands.peek());
                }
                else if (s == "/")
                {
                    b = operands.pop();
                    a = operands.pop();
                    operands.push(a / b);
                    //System.out.println(operands.peek());
                }
                else if (s == "+")
                {
                    b = operands.pop();
                    a = operands.pop();
                    operands.push(a + b);
                    //System.out.println(operands.peek());
                }
                else
                {
                    b = operands.pop();
                    a = operands.pop();
                    operands.push(a - b);
                    //System.out.println(operands.peek());
                }
            }
        }
        result = operands.pop();
        return result;
    }

    public double returnAnswer() { return result; }
}
