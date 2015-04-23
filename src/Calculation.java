/**
 * Created by porrith on 4/20/15.
 */
public class Calculation {

    private double memory;
    private char operator;

    public Calculation(GUI window)
    {
        memory = 0.0;
    }

    public void setMemory(String memoryVal)
    {
        memory = Double.parseDouble(memoryVal);
    }

    public double getMemory() { return memory; }


}
