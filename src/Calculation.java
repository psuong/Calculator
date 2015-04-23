import javax.swing.*;
import java.util.Vector;

/**
 * Created by porrith on 4/20/15.
 */
public class Calculation {

    private double memory;

    private Vector<String>infixNotation;

    public Calculation()
    {
        memory = 0.0;
        infixNotation = new Vector<String>();
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

    public void checkLast()
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
}
