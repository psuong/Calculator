import javax.swing.*;
import java.util.Stack;
import java.util.Vector;

/**
 * Created by porrith on 4/20/15.
 * Must convert infix to postfix
 */
public class Calculation {

    private double memory;

    private Vector<String>infixNotation; //Stores the prefix notation placed into the calculator
    private Vector<String>postfixNotation; //Stores the postfix notation
    private Stack<String>operators;

    public Calculation()
    {
        memory = 0.0;
        infixNotation = new Vector<String>();
        postfixNotation = new Vector<String>();
        operators = new Stack<String>();
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
        for (int i = 0; i < infixNotation.size() - 1; i++) {
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
            else if((s == "+" || s == "-" || s == "*" || s == "/") && operators.isEmpty())
            {
                operators.push(s);
            }
            else if((operators.peek() == "+" || operators.peek() == "-") && (s == "*" || s == "/"))
            {
                operators.push(s);
            }
            else if ((operators.peek() == "*" || operators.peek() == "/") && (s == "+" || s == "-"))
            {
                while(!operators.isEmpty())
                {
                    postfixNotation.add(operators.pop());
                }
            }
        }
    }

    public void printPostfix()
    {
        for (int i = 0; i < postfixNotation.size(); i++) {
            System.out.println(postfixNotation.elementAt(i));
        }
    }
}
